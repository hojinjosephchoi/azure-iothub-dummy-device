이 Repository는 [MS Azure IoT Hub 관련 실습](https://github.com/KoreaEva/IoT/tree/master/Labs/IoT_Hub) 중 .Net버전의 [3.Device_Programming](https://github.com/KoreaEva/IoT/blob/master/Labs/IoT_Hub/3.Device_Programming.md) 내용을 Java 버전으로 작성한 것입니다.

# 작업순서
## 1. IoT Hub와 연결을 위한 장치ID 만들기

- [IoT Hub 만들기](https://docs.microsoft.com/ko-kr/azure/iot-hub/iot-hub-java-java-getstarted#a-namecreate-an-iot-hubaiot-hub-만들기)의 6. 공유 액세스 정책 부분을 참고하여, '연결 문자열-기본키'를 복사합니다.
- `com.lattekafe.create_device_identity.Main` Class의 `connectionString` 변수 `{yourhubconnectionstring}`에 copy한 후 해당 클래스를 실행합니다.
~~~ java
//com.lattekafe.create_device_identity.Main.java 소스파일내
private static final String connectionString = "{yourhubconnectionstring}";
~~~

- 출력된 Device Key를 메모합니다.

## 2. Dummy Sensor 실행하기

- 앞서 가져온 Device Key값을 `com.lattekafe.dummysensor.Main` Class의 `connectionString`변수 `{yourdevicekey}`에 copy한 후 해당 클래스를 실행합니다.

~~~ java
//com.lattekafe.dummysensor.Main.java 
String connectionString = "HostName={youriothubname}.azure-devices.net;DeviceId=Device1;SharedAccessKey={yourdevicekey}";
~~~
---
# References

- [IoT Hub 실습](https://github.com/KoreaEva/IoT/tree/master/Labs/IoT_Hub)  
- [Azure IoT Hub 시작(Java)](https://docs.microsoft.com/ko-kr/azure/iot-hub/iot-hub-java-java-getstarted)
