package com.lattekafe.create_device_identity;

import java.io.IOException;
import java.net.URISyntaxException;

import com.microsoft.azure.iot.service.exceptions.IotHubException;
import com.microsoft.azure.iot.service.sdk.Device;
import com.microsoft.azure.iot.service.sdk.RegistryManager;

/**
 * 장치 ID 만들기
 * 
 * IoT Hub의 ID 레지스트리에서 장치 ID를 만드는 Java 콘솔 앱을 작성합니다.
 * 
 * 이 콘솔 앱을 실행하면 장치-클라우드 메시지를 IoT Hub로 보낼 때 
 * 장치가 자체적으로 ID를 식별하는 데 사용할 수 있는 고유한 장치 ID와 키를 생성합니다.
 * 
 * 참고 : https://docs.microsoft.com/ko-kr/azure/iot-hub/iot-hub-java-java-getstarted#a-namecreate-a-device-identitya장치-id-만들기
 *
 */
public class Main {

	private static final String connectionString = "{yourhubconnectionstring}";
	private static final String deviceId = "Device1";
	
	public static void main(String[] args) throws IOException, URISyntaxException, Exception {
		RegistryManager registryManager = RegistryManager.createFromConnectionString(connectionString);
		
		Device device = Device.createFromId(deviceId, null, null);
		
		try{
			device = registryManager.addDevice(device);
			
		} catch (IotHubException iote){
			
			try{
				device = registryManager.getDevice(deviceId);
			}catch (IotHubException iotf) {
				
				iotf.printStackTrace();
			}
			
		}
		
		System.out.println("Device ID: " + device.getDeviceId());
		System.out.println("Device Key: " + device.getPrimaryKey());
	}
}
