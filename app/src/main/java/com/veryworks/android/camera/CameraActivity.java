package com.veryworks.android.camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView imageView;
    Button btnCapture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        setView();
        setListener();
    }
    private void setView(){
        imageView = (ImageView) findViewById(R.id.imageView);
        btnCapture = (Button) findViewById(R.id.btnCapture);
    }
    private void setListener(){
        btnCapture.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        takePhoto();
    }

    private void takePhoto(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Const.Camera.REQ_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 요청코드 구분
        if(requestCode == Const.Camera.REQ_CAMERA){
            // 결과처리 상태 구분
            if (resultCode == RESULT_OK) {
                Uri imageUri = data.getData();
                imageView.setImageURI(imageUri);
            }
        }
    }
}
