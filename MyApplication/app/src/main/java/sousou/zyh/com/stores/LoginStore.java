package sousou.zyh.com.stores;


import android.widget.Toast;

import java.util.Map;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import sousou.zyh.com.App;
import sousou.zyh.com.actions.Action;
import sousou.zyh.com.actions.CommonAction;
import sousou.zyh.com.common.ApiService;
import sousou.zyh.com.common.UrlConstant;
import sousou.zyh.com.model.GetIpInfoResponse;
import sousou.zyh.com.model.Message;
import sousou.zyh.com.model.UserInfo;

/**
 * Created by zyh on 2016/4/8.
 */
public class LoginStore extends Store<Store.LoginChangeEvent>{
    Message message=new Message();
    private static final String ENDPOINT = "http://ip.taobao.com";

    public String getMessage() {
        return message.getMessage();
    }


    @Override
    public LoginChangeEvent changeEvent() {

        return new LoginChangeEvent();
    }

    @Override
    public void onAction(Action action) {
        switch (action.getType()){
            case CommonAction.ACTION_LGOIN:
                 /* Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);

                mProgressBar.setVisibility(View.VISIBLE);

                Call<GetIpInfoResponse> call = apiService.getIpInfo("63.223.108.42");
                call.enqueue(new Callback<GetIpInfoResponse>() {
                    @Override
                    public void onResponse(Response<GetIpInfoResponse> response, Retrofit retrofit) {
                        mProgressBar.setVisibility(View.GONE);
                        GetIpInfoResponse getIpInfoResponse = response.body();
                        mTvContent.setText(getIpInfoResponse.data.country);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        mProgressBar.setVisibility(View.GONE);
                        mTvContent.setText(t.getMessage());
                    }
                });*/


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(UrlConstant.LOGINURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
//                apiService.getIpInfo("63.223.108.42")
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Subscriber<GetIpInfoResponse>() {
//
//                            @Override
//                            public void onCompleted() {
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                            }
//
//                            @Override
//                            public void onNext(GetIpInfoResponse getIpInfoResponse) {
//                                Toast.makeText(App.getInstance(),getIpInfoResponse.data.country,1).show();
//                            }
//                        });

//                apiService.getIpInfo("63.223.108.42")
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Action1<GetIpInfoResponse>() {
//                            @Override
//                            public void call(GetIpInfoResponse getIpInfoResponse) {
//                                Toast.makeText(App.getInstance(), getIpInfoResponse.data.country, 1).show();
//                            }
//                        });
                Map<String,String> map= (Map)action.getData();
//                UserInfo userInfo=new UserInfo();
//                userInfo.setUserName(map.get("username"));
//                userInfo.setPassword(map.get("password"));

                apiService.login(map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String string) {
                                Toast.makeText(App.getInstance(), string, 1).show();
                            }
                        });

                break;
            case CommonAction.ACTION_REGISTER:

                break;
        }
//        emitStoreChange();
    }
}


//Map<String,String> map= (Map)action.getData();
//message.setMessage(map.get("username")+map.get("password"));
//
//        GsonRequest<BaseModel> gsonRequest = new GsonRequest<BaseModel>(Request.Method.POST,
//        UrlConstant.LOGINURL,map, BaseModel.class,new Response.Listener<BaseModel>() {
//@Override
//public void onResponse(BaseModel baseModel) {
//
//        }
//        }, new Response.ErrorListener() {
//@Override
//public void onErrorResponse(VolleyError error) {
//
//        }
//        });
//
//
//        App.getInstance().addRequest(gsonRequest, "LoginStore");
