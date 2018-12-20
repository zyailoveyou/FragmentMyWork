package com.cop.zqc.fragmentmywork;

import android.app.FragmentManager;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFragment.ListViewOnClick {

    private ListView mListSelect;
    private TextFragment mMyTextFragment;
    private ListFragment mMyListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMyTextFragment = new TextFragment();
        mMyListFragment = new ListFragment();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.layout_listF, mMyListFragment);
        fragmentTransaction.add(R.id.layout_listT, mMyTextFragment);

        fragmentTransaction.commit();


    }

    @Override
    public void OnClickItem(AdapterView<?> parent, View view, int position, long id) {

//        TextFragment fragment = new TextFragment();
//
//        FragmentManager fragmentManager = getFragmentManager();
//
//        fragment = (TextFragment) (fragmentManager.findFragmentById(R.id.ListT));
//
//        TextView StringWord = view.findViewById(R.id.TextString);
//
//        fragment.SetText((String) (StringWord.getText()));

        MyTransition myTransition = new MyTransition();

        ViewGroup RootViewGroup = findViewById(R.id.layout_listT);

        Scene scene1 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_articlecontent,this);

        Scene scene2 = Scene.getSceneForLayout(RootViewGroup,R.layout.fragment_change,this);

        TransitionManager.go(scene1,myTransition);
//
//        TextFragment2 textFragment2 = new TextFragment2();
//
//        FragmentManager fragmentManager = getFragmentManager();
//
//        fragmentManager.beginTransaction().addToBackStack("SaveF").replace(R.id.layout_listT,textFragment2).
//                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();


//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);

//        fragmentTransaction.remove(fragment);

//        fragmentTransaction.replace(,fragment);
//
//        fragmentTransaction.commit();

//        fragment = (TextFragment) (fragmentManager.findFragmentById(R.id.ListT));
//
//        TextView StringWord = view.findViewById(R.id.TextString);

//        fragment.SetText((String) (StringWord.getText()));

    }

}
