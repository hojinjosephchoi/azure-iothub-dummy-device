package com.lattekafe.dummysensor.biz;

import com.lattekafe.dummysensor.model.WeatherModel;
import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.Message;

public class MessageSender implements Runnable {

	public volatile boolean stopThread = false;
	
	private DeviceClient client;
	private String deviceId;
	
	



	public MessageSender(DeviceClient client, String deviceId) {
		super();
		this.client = client;
		this.deviceId = deviceId;
	}



	@Override
	public void run() {

		try {
			
			while(!stopThread){
				
				WeatherModel weather = new WeatherModel();
				weather.setDeviceId(this.deviceId);
				weather.setTemperature((int)(Math.random() * (40 - 20 + 1)) + 20);
				weather.setHumidity((int)(Math.random() * (60 - 40 + 1)) + 40);
				weather.setDust(50 + weather.getTemperature() + (int)(Math.random() * (5 - 1 + 1)) + 1);
				
				String msgStr = weather.serialize();
				Message msg = new Message(msgStr);
				System.out.println("Sending : " + msgStr);
				
				Object lockobj = new Object();
				EventCallback callback = new EventCallback();
				client.sendEventAsync(msg, callback, lockobj);
				
				synchronized (lockobj){
					lockobj.wait();
				}
				Thread.sleep(5000);
				
			}

		} catch (InterruptedException e) {
			System.out.println("Finished.");
		}

	}

}
