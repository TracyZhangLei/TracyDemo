package cc.tracyzhang.app.tracydemo.java8;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cc.tracyzhang.app.tracydemo.R;

/**
 * Created by zl on 17-4-10.
 */

public class Java8Activity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java8);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.lambda:
                Toast.makeText(this,"hehe",Toast.LENGTH_LONG).show();
                Log.d("", "onClick: ");
                break;

        }
    }
}
