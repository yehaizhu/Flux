package sousou.zyh.com.stores;


import com.squareup.otto.Bus;

import sousou.zyh.com.actions.Action;

/**
 * Flux的Store模块
 * Created by zyh on 18/12/15.
 */
public abstract class Store<T> {
    private  static final Bus bus = new Bus();

    protected Store() {
    }

    public void register(final Object view) {
        this.bus.register(view);
    }

    public void unregister(final Object view) {
        this.bus.unregister(view);
    }

    void emitStoreChange() {
        this.bus.post(changeEvent());
    }

    public abstract T changeEvent();
    public abstract void onAction(Action action);

    public class StoreChangeEvent {}
    public class LoginChangeEvent {}
}