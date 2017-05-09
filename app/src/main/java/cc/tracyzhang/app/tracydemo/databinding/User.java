package cc.tracyzhang.app.tracydemo.databinding.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import cc.tracyzhang.app.tracydemo.BR;

/**
 * User: zhanglei115
 * Date: 16-5-13
 * Description:
 */
public class User extends BaseObservable{
    public String firstName;
    public String lastName;
    public boolean isFriend;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.user);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }

    @Bindable
    public String getFirstName() {
        return firstName;
    }
    @Bindable
    public String getLastName() {
        return lastName;
    }
    @Bindable
    public boolean isFriend() {
        return isFriend;
    }
}
