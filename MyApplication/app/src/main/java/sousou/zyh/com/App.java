package sousou.zyh.com;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import sousou.zyh.com.utils.CrashHandler;
import sousou.zyh.com.utils.LruBitmapCache;
import sousou.zyh.com.utils.http.OkHttp3Stack;

/**
 * Created by Allen Lin on 2016/02/17.
 */
public class App extends Application {
    public static final String TAG = "App";
    public RequestQueue mRequestQueue;//请求队列
    private ImageLoader mImageLoader;
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        CrashHandler.getInstance().init(this);

    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());/*,
                    new OkHttp3Stack());*/
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache(this));
        }
        return this.mImageLoader;
    }

    public <T> void addRequest(Request<T> req, String tag) {
        req.setTag(tag);
        getRequestQueue().add(req);

    }

    public <T> void addRequest(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}

