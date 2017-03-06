package com.lattekafe.dummysensor;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lattekafe.dummysensor.biz.MessageSender;
import com.microsoft.azure.iothub.DeviceClient;
import com.microsoft.azure.iothub.IotHubClientProtocol;

/**
 * 시뮬레이션된 장치 앱 만들기
 * 
 * IoT Hub로 장치-클라우드 메시지를 전송하는 장치를 시뮬레이션하는 Java 콘솔 앱을 작성합니다.
 *
 * 참고 ; https://docs.microsoft.com/ko-kr/azure/iot-hub/iot-hub-java-java-getstarted#a-namecreate-a-simulated-device-appa시뮬레이션된-장치-앱-만들기
 */
public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException {
		
		String connectionString = "HostName={youriothubname}.azure-devices.net;DeviceId=Device1;SharedAccessKey={yourdevicekey}";
		IotHubClientProtocol protocol = IotHubClientProtocol.MQTT;
		String deviceId = "Device1";
		
		DeviceClient client = new DeviceClient(connectionString, protocol);
		client.open();
		
		MessageSender sender = new MessageSender(client, deviceId);
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(sender);
		
		System.out.println("Press Enter to exit.");
		System.in.read();
		
		System.out.println("byebye");
		executor.shutdown();
		client.close();
		
	}
	
	
	
}
