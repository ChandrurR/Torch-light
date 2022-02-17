package com.example.torch_light;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout layout;
    CameraManager cameraManager;
    String cameraid;
    Boolean state=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout=findViewById(R.id.off);
        layout.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                if(!state)
                {
                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraid=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraid,!state);
                        layout.setBackgroundResource(R.drawable.light_off);
                        state=true;


                    } catch (CameraAccessException e)
                    {
                        e.printStackTrace();
                    }
                }
                else

                    {

                    try {
                        cameraManager= (CameraManager) getSystemService(CAMERA_SERVICE);
                        cameraid=cameraManager.getCameraIdList()[0];
                        cameraManager.setTorchMode(cameraid,!state);
                        layout.setBackgroundResource(R.drawable.light_on);
                        state=false;

                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }

                }
            }

        });
    }
}