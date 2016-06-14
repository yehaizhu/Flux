package sousou.zyh.com.stores;

import com.squareup.otto.Subscribe;

import sousou.zyh.com.actions.Action;
import sousou.zyh.com.actions.MessageAction;
import sousou.zyh.com.model.Message;

/*文／ntop（简书作者）
        原文链接：http://www.jianshu.com/p/5aa9cbde299f
        著作权归作者所有，转载请联系作者获得授权，并标注“简书作者”。*/

/**
 * MessageStore类主要用来维护MainActivity的UI状态
 * Created by ntop on 18/12/15.
 */
public class MessageStore extends Store<Store.StoreChangeEvent> {
    private static MessageStore singleton;
    private Message mMessage = new Message();

    public MessageStore() {
        super();
    }

    public String getMessage() {
        return mMessage.getMessage();
    }

    @Override
    @Subscribe
    public void onAction(Action action) {
        switch (action.getType()) {
            case MessageAction.ACTION_NEW_MESSAGE:
                mMessage.setMessage((String) action.getData());
                break;
            default:
        }
        emitStoreChange();
    }


    @Override
    public StoreChangeEvent changeEvent() {
        return new StoreChangeEvent();
    }
}