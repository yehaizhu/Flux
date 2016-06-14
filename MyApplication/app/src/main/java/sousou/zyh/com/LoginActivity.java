package sousou.zyh.com;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.HashMap;
import java.util.Map;

import sousou.zyh.com.actions.ActionsCreator;
import sousou.zyh.com.dispatcher.Dispatcher;
import sousou.zyh.com.stores.LoginStore;
import sousou.zyh.com.stores.Store;

/**
 * Created by Administrator on 2016/4/8.
 */
public class LoginActivity extends FragmentActivity {

    private Button btn_register;
    private Button btn_login;
    private EditText et_username;
    private EditText et_password;
    private Dispatcher dispatcher;
    private ActionsCreator actionsCreator;
    private LoginStore store;
    private Map<String, String> map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initDependencies();
        initView();
        setOnclick();

    }

    private void initDependencies() {
        dispatcher = Dispatcher.get();
        actionsCreator = ActionsCreator.get(dispatcher);
        store = new LoginStore();
        dispatcher.register(store);
        map = new HashMap<String,String>();

    }


    private void initView() {
        et_username = (EditText)this.findViewById(R.id.et_username);
        et_password = (EditText)this.findViewById(R.id.et_password);
        btn_register = (Button)this.findViewById(R.id.bt_register);
        btn_login = (Button) this.findViewById(R.id.bt_login);
    }

    private void setOnclick() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                if(TextUtils.isEmpty(username)){
                    Toast.makeText(LoginActivity.this,"请输入用户名",1).show();
                    return;

                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"请输入密码",1).show();
                    return;

                }
                map.put("username",username);
                map.put("password",password);
                actionsCreator.login(map);

            }
        });
    }

    @Subscribe
    public void onStoreChange(Store.LoginChangeEvent event) {
        Toast.makeText(this,store.getMessage(),1).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        store.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        store.unregister(this);
    }
}
