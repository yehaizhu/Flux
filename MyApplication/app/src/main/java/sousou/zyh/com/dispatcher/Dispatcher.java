package sousou.zyh.com.dispatcher;


import java.util.ArrayList;
import java.util.List;

import sousou.zyh.com.actions.Action;
import sousou.zyh.com.stores.Store;

/**
 * Flux的Dispatcher模块
 * Created by zyh on 18/12/15.
 */
public class Dispatcher {
    private static Dispatcher instance;
    private final List<Store> stores = new ArrayList<Store>();

    public static Dispatcher get() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    Dispatcher() {}

    public void register(final Store store) {
        stores.add(store);
    }

    public void unregister(final Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(final Action action) {
        for (Store store : stores) {
            store.onAction(action);
        }
    }
}