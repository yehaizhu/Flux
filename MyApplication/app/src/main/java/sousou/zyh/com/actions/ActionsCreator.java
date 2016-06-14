package sousou.zyh.com.actions;


import java.util.Map;

import sousou.zyh.com.dispatcher.Dispatcher;

/**
 * Flux的ActionCreator模块
 * Created by ntop on 18/12/15.
 */
public class ActionsCreator {

    private static ActionsCreator instance;
    final Dispatcher dispatcher;

    ActionsCreator(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public static ActionsCreator get(Dispatcher dispatcher) {
        if (instance == null) {
            instance = new ActionsCreator(dispatcher);
        }
        return instance;
    }

    public void sendMessage(String message) {
        dispatcher.dispatch(new MessageAction(MessageAction.ACTION_NEW_MESSAGE, message));
    }

    public void login(Map<String,String> map) {
        dispatcher.dispatch(new LoginAction(CommonAction.ACTION_LGOIN, map));
    }
}