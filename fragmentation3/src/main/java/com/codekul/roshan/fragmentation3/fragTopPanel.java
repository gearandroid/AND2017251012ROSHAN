package com.codekul.roshan.fragmentation3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragTopPanel extends Fragment {


    public fragTopPanel() {
        // Required empty public constructor
    }
    public static fragTopPanel getInstance(){
        fragTopPanel frgTop=new fragTopPanel();
        return frgTop;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View rootView =inflater.inflate(R.layout.fragment_frag_top_panel, container, false);

     clickButtons(rootView);

     return rootView;
    }

    public void clickButtons(View rootView){
        rootView.findViewById(R.id.btnNagraj).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.nagraj);
            }
        });

        rootView.findViewById(R.id.btnDhruv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.dhruv);
            }
        });
    }

    public void show(int image){
        MainActivity activity = (MainActivity) getActivity();
        activity.loadFragment(R.id.frameContainer,frameContainer.getInstance(image));
    }

}
