package com.codekul.roshan.fragmentation2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragPanel extends Fragment {

    public FragPanel() {
        // Required empty public constructor
    }

    public static FragPanel getInstance(){

        FragPanel fragPanel=new FragPanel();

        return fragPanel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag_panel, container, false);

        clickButtons(rootView);
        return rootView;
    }

    private void clickButtons(View rootview){

        rootview.findViewById(R.id.btnMon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.monday);
            }
        });

        rootview.findViewById(R.id.btnTue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.tuesday);
            }
        });

        rootview.findViewById(R.id.btnWed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.wednesday);
            }
        });

        rootview.findViewById(R.id.btnThu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.thursday);
            }
        });

        rootview.findViewById(R.id.btnFri).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.friday);
            }
        });

        rootview.findViewById(R.id.btnSat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.friday1);
            }
        });

        rootview.findViewById(R.id.btnSun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                show(R.drawable.sunday);
            }
        });

    }
    //final MainActivity activity = (MainActivity)getActivity();
    private void show(int img){
        ((MainActivity)getActivity()).loadFragment(R.id.frameContainor,FragMain.getInstance(img));
    }

}
