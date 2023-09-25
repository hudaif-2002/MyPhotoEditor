package com.example.myeditor;

import static com.example.myeditor.MainActivity.imgUri;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.dsphotoeditor.sdk.activity.DsPhotoEditorActivity;
import com.dsphotoeditor.sdk.utils.DsPhotoEditorConstants;
import com.example.myeditor.databinding.ActivityFinalBinding;


public class FinalActivity extends AppCompatActivity {
ActivityFinalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityFinalBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        Intent dsPhotoEditorIntent = new Intent(this, DsPhotoEditorActivity.class);
        dsPhotoEditorIntent.setData(imgUri);

        dsPhotoEditorIntent.putExtra(
                DsPhotoEditorConstants.DS_PHOTO_EDITOR_OUTPUT_DIRECTORY,
                "My Editor");

        startActivityForResult(dsPhotoEditorIntent,200);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            switch (requestCode)
            {
                case 200:
                    Uri outputUri =data.getData();
                    binding.imgView.setImageURI(outputUri);
                    break;
            }
        }
    }
}