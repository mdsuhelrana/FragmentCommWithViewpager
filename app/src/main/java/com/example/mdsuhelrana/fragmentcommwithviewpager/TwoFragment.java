package com.example.mdsuhelrana.fragmentcommwithviewpager;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    private TextView tvShowMessage;
    private ImageView showImage;


    public TwoFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_two, container, false);
        tvShowMessage=view.findViewById(R.id.showMessage_Id);
        showImage=view.findViewById(R.id.showImage_Id);
        String tag=getTag();
        ((MainActivity)getActivity()).setTabFragmentB(tag);
        return view;
    }

    public void setMessage(String message){
        tvShowMessage.setText(message);
    }

    public void setImage(Bitmap bitmap){
        if(bitmap !=null) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            byte[] byteArray = outputStream.toByteArray();
//        ByteArrayInputStream stream=new ByteArrayInputStream(byteArrau);
//        Bitmap bitmap1=BitmapFactory.decodeStream(stream);
            Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            showImage.setImageBitmap(bmp);
        }

    }


}
