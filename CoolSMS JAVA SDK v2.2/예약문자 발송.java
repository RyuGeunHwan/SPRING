// 예약해둔 날짜에 문자 메시지를 보낼 수 있습니다.
// params 의 datetime 에 날짜를 넣어주세요. 예) '20160221150000' // 2016년 2월 21일 15시 00분 00초

package net.nurigo.java_sdk.examples.Message;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class ExampleSend {
  public static void main(String[] args) {
    String api_key = "#ENTER_YOUR_OWN#";
    String api_secret = "#ENTER_YOUR_OWN#";
    Message coolsms = new Message(api_key, api_secret);

    // 4 params(to, from, type, text) are mandatory. must be filled
    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", "01000000000");
    params.put("from", "01000000000");
    params.put("type", "SMS");
    params.put("text", "Coolsms Testing Message!");
    params.put("app_version", "test app 1.2"); // application name and version
    params.put("datetime", "20160221150000"); // Format must be(YYYYMMDDHHMISS) 2016-02-21 15:00:00

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}