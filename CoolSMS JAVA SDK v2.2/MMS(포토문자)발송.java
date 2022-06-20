// 이미지( 300KB미만의 2024*2024이하 JPG, GIF, PNG ) 를 포함한 내용을 문자 메시지로 보낼 수 있습니다.
// params 의 type 을 'MMS'로 바꿔주세요.
// params 의 image 에 해당 경로와 함께 이미지 파일명을 넣어주세요. 예) './images/test.jpg'

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
    params.put("image", "images/test.jpg"); // image for MMS. type must be set as "MMS"

    try {
      JSONObject obj = (JSONObject) coolsms.send(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}