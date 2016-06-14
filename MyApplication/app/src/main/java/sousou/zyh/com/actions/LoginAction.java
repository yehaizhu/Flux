package sousou.zyh.com.actions;

import java.util.Map;

/**
 * Created by zyh on 2016/4/8.
 */
public class LoginAction extends Action<Map<String,String>> {

    LoginAction(String type, Map<String, String> data) {
        super(type, data);
    }
}
