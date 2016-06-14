package sousou.zyh.com;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.otto.Subscribe;

import sousou.zyh.com.actions.ActionsCreator;
import sousou.zyh.com.dispatcher.Dispatcher;
import sousou.zyh.com.stores.MessageStore;
import sousou.zyh.com.stores.Store;

/***
 *Flux的Controller-View模块
 *Created by ntop on 18/12/15.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText vMessageEditor;
    private Button vMessageButton;
    private TextView vMessageView;

    private Dispatcher dispatcher;
    private ActionsCreator actionsCreator;
    private MessageStore store;

    private String TAG=MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDependencies();
        setupView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatcher.unregister(store);
    }

    private void initDependencies() {
        dispatcher = Dispatcher.get();
        actionsCreator = ActionsCreator.get(dispatcher);
        store = new MessageStore();
        dispatcher.register(store);
    }

    private void setupView() {
        vMessageEditor = (EditText) findViewById(R.id.message_editor);
        vMessageView = (TextView) findViewById(R.id.message_view);
        vMessageButton = (Button) findViewById(R.id.message_button);
        vMessageButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.message_button) {
            if (vMessageEditor.getText() != null) {
                actionsCreator.sendMessage(vMessageEditor.getText().toString());
                vMessageEditor.setText(null);
            }
        }
    }

    private void render(MessageStore store) {

        vMessageView.setText(store.getMessage());
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

    /*文／ntop（简书作者）
    原文链接：http://www.jianshu.com/p/5aa9cbde299f
    著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。*/

    @Subscribe
    public void onStoreChange(Store.StoreChangeEvent event) {

        render(store);
    }
}



/*//            Map<String,String> map=new HashMap<String,String>();
            String url="http://121.196.228.142/Iface/";
            Map<String,String> dataMap=new HashMap<String,String>();
            JSONObject dataObj=new JSONObject();


            try {
                dataObj.put("command","login");
                dataObj.put("mobileNo","18157511721");
                dataObj.put("passwd","123456");
                String  data=dataObj.toString();
                dataMap.put("data",data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            GsonRequest<BaseModel> gsonRequest = new GsonRequest<BaseModel>(Request.Method.POST,
                    url,dataMap, BaseModel.class,new Response.Listener<BaseModel>() {
                @Override
                public void onResponse(BaseModel baseModel) {
                    Toast.makeText(MainActivity.this, baseModel.code+"", 1).show();
                    Toast.makeText(MainActivity.this, baseModel.msg+"", 1).show();
                    String   userStr=GsonUtil.objectToString(baseModel.data);
                    UserInfo userInfo=GsonUtil.jsonToBean(userStr, UserInfo.class);
                    Toast.makeText(MainActivity.this, userInfo.getUserName()+"", 1).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("ggg", error.getMessage(), error);
                }
            });

            App.getInstance().addRequest(gsonRequest, "TestActivity");*/