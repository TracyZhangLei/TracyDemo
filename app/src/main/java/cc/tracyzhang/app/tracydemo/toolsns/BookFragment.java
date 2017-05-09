package cc.tracyzhang.app.tracydemo.toolsns;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cc.tracyzhang.app.tracydemo.R;

/**
 * User: zhanglei115
 * Date: 16-5-27
 * Description:
 */
public class BookFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book,container);
    }

}
