package com.example.scalableui;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoFragment extends Fragment {

    private static final String TAG = "PhotoFragment";

    private ImageView mImgView;
    private OnPhotoFragmentInteractionListener mListener;


    public PhotoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPhotoFragmentInteractionListener) {
            mListener = (OnPhotoFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: starting ...");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photo, container, false);
        mImgView = view.findViewById(R.id.img2);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: starting ...");

        try{
            mImgView.setImageBitmap(mListener.onPhotoFragmentInteraction());
        }
        catch (NullPointerException e){
            Log.d(TAG, "onResume: NullPointer");
        }

    }

    public interface OnPhotoFragmentInteractionListener{
        public Bitmap onPhotoFragmentInteraction();
    }

}
