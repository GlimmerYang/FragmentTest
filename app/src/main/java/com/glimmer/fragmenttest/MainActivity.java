package com.glimmer.fragmenttest;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @Bind(R.id.rl_main)
    RelativeLayout mRlMain;

    OneFragment oneFragment;
    TwoFragment twoFragment;
    ThreeFragment threeFragment;
    @Bind(R.id.btn_next)
    Button mBtnNext;

    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                index++;
                switch (index%3){
                    case 0:
                        transaction.replace(R.id.rl_main, oneFragment);
                        break;
                    case 1:
                        transaction.replace(R.id.rl_main, twoFragment);
                        break;
                    case 2:
                        transaction.replace(R.id.rl_main, threeFragment);
                        break;
                    default:
                        break;
                }
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        if (mRlMain != null) {

            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.rl_main, oneFragment);
            transaction.commit();
        }


    }

}
