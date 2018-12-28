package com.cop.zqc.fragmentmywork;

import android.app.ActionBar;
import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements ListFragment.ListViewOnClick {

    private ListView mListSelect;
    private TextFragment mMyTextFragment;
    private ListFragment mMyListFragment;
    private boolean ToWhichScence;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar MyToolBar = findViewById(R.id.MyToolBar);

        MyToolBar.inflateMenu(R.menu.activity_main);



        mMyTextFragment = new TextFragment();
        mMyListFragment = new ListFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.layout_listF, mMyListFragment);

        fragmentTransaction.add(R.id.layout_listT, mMyTextFragment);

        fragmentTransaction.commit();

        ToWhichScence=false;

    }

    @Override
    public void OnClickItem(AdapterView<?> parent, View view, int position, long id) {

        MyTransitionIN myTransitionIN = new MyTransitionIN();
        MyTransitionOUT myTransitionOUT = new MyTransitionOUT();
        android.support.v7.app.ActionBar MyactionBar = getSupportActionBar();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        mMyTextFragment.setExitTransition(myTransitionOUT);
//        fragmentTransaction.remove(mMyTextFragment);
//        fragmentTransaction.commit();

        ViewGroup RootViewGroup = findViewById(R.id.layout_listT);

        RootViewGroup.getX();
        RootViewGroup.getWidth();

        Scene scene1 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_articlecontent,this);

        Scene scene2 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_change,this);


       if (ToWhichScence == false) {
           TransitionManager.go(scene2, myTransitionOUT);
           ToWhichScence = true;
           MyactionBar.hide();
       }

        else
            {

            TransitionManager.go(scene1,myTransitionOUT);
                ToWhichScence = false;
                MyactionBar.show();
        }


    }

}
