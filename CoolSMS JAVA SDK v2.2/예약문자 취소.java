// 아직 발송되지 않은 예약문자를 취소 할 수 있습니다.
// params 의 mid or gid 안에 해당 문자의 mid나 gid를 넣어주시면 됩니다.

package net.nurigo.java_sdk.examples.Message;

import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleCancel
 * @brief This sample code demonstrate how to cancel reserved sms through CoolSMS Rest API PHP
 */
public class ExampleCancel {
  public static void main(String[] args) {
    String api_key = "#ENTER_YOUR_OWN#";
    String api_secret = "#ENTER_YOUR_OWN#";
    Message coolsms = new Message(api_key, api_secret);

    // Either mid or gid is must be entered
    HashMap<String, String> params = new HashMap<String, String>();
    // params.put("message_id", "M52CB443257C61"); // message id
    // params.put("group_id", "G52CB4432576C8"); // group id

    try {
      JSONObject obj = (JSONObject) coolsms.cancel(params);
      System.out.println(obj.toString());
    } catch (CoolsmsException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getCode());
    }
  }
}