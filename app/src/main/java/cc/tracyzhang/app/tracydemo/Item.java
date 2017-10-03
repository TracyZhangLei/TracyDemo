package cc.tracyzhang.app.tracydemo;

import android.support.annotation.NonNull;

/**
 * User: zhanglei115
 * Date: 16-5-13
 * Description:
 */
public class Item implements Comparable<Item> {

    public String name;
    public Class cls;

    public Item(String name, Class cls) {
        this.name = name;
        this.cls = cls;
    }

    public Item() {
    }


    @Override
    public int compareTo(@NonNull Item another) {
        return name.compareTo(another.name);
    }
}
