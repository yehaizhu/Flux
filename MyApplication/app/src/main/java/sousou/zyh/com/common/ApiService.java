package sousou.zyh.com.common;


import java.util.Map;

import retrofit.http.Body;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;
import sousou.zyh.com.model.GetIpInfoResponse;
import sousou.zyh.com.model.UserInfo;

/**
 * Created by zyh on 2016/4/9.
 */
public interface ApiService {
     /*  @GET("service/getIpInfo.php")
    Call<GetIpInfoResponse> getIpInfo(@Query("ip") String ip);*/

    @GET("service/getIpInfo.php")
    Observable<GetIpInfoResponse> getIpInfo(@Query("ip") String ip);

    //    @POST("login.php")
//    Observable<GetIpInfoResponse> login(@POST("ip") String ip);
    @POST("post.php")
    Observable<String> login(@Body UserInfo user);

    @FormUrlEncoded
    @POST("post.php")
    Observable<String> login(@FieldMap Map<String, String> map);



}
