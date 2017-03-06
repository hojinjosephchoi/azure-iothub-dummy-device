package com.lattekafe.dummysensor.biz;

import com.microsoft.azure.iothub.IotHubEventCallback;
import com.microsoft.azure.iothub.IotHubStatusCode;

public class EventCallback implements IotHubEventCallback {

	@Override
	public void execute(IotHubStatusCode responseStatus, Object callbackContext) {

		System.out.println("IoT Hub responded to message with status: " + responseStatus.name());
		if (callbackContext != null) {
			synchronized (callbackContext) {
				callbackContext.notify();
			}
		}
	}

}
