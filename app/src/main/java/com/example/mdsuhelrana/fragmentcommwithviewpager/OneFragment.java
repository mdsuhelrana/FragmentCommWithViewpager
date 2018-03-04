package com.example.mdsuhelrana.fragmentcommwithviewpager;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {
    private EditText etsendMessage;
    private Button btnSend;
    private Button btnChose;
    private ImageView imageView;
    private int CAMERA_REQUEST=1;
    private Bitmap bitmap;

    public OneFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_one, container, false);

        etsendMessage=view.findViewById(R.id.etMessage_Id);
        btnSend=view.findViewById(R.id.sendMessage_Id);
        btnChose=view.findViewById(R.id.chose_Id);
        imageView=view.findViewById(R.id.image_Id);
        btnSend.setOnClickListener(listener);
        btnChose.setOnClickListener(listener2);
       return view;
    }
    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           String message= etsendMessage.getText().toString();
           String tag=((MainActivity)getActivity()).getTabFragmentB();
           TwoFragment twoFragment= (TwoFragment) getActivity().getSupportFragmentManager()
                   .findFragmentByTag(tag);
           twoFragment.setMessage(message);
           twoFragment.setImage(bitmap);
        }
    };
    View.OnClickListener listener2=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent, CAMERA_REQUEST);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CAMERA_REQUEST ){
            if (resultCode==MainActivity.RESULT_OK){
             bitmap= (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream=new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);

                byte[] byteArray=stream.toByteArray();
                Bitmap bmp= BitmapFactory.decodeByteArray(byteArray,0,byteArray.length);
                imageView.setImageBitmap(bmp);
            }
        }
    }
}
