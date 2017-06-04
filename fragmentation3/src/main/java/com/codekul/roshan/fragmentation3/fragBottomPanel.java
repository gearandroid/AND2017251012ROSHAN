package com.codekul.roshan.fragmentation3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragBottomPanel extends Fragment {


    public fragBottomPanel() {
        // Required empty public constructor
    }

    public static fragBottomPanel getInstance(){
        fragBottomPanel frgBottom = new fragBottomPanel();
        return frgBottom;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_frag_bottom_panel, container, false);

        clickButtn(rootView);
        return rootView;
    }

    private void clickButtn(View rootView){
        rootView.findViewById(R.id.btnBlackCat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.blackcat);
            }
        });
        rootView.findViewById(R.id.btnDoga).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show(R.drawable.doga);
            }
        });
    }

    private void show(int image){
        MainActivity activity = (MainActivity) getActivity();
        activity.loadFragment(R.id.frameContainer,frameContainer.getInstance(image));
    }

}
