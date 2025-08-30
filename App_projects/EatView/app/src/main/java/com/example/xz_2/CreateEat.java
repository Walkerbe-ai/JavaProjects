package com.example.xz_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;

public class CreateEat extends AppCompatActivity {
    private EditText nameEat;
    private EditText descriptionEat;
    private ImageView photoEat;
    static final int GALLERY_REQUEST = 1;
    private Bitmap bitmap = null;
    private Button btnloadphoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_eat);
        btnloadphoto = findViewById(R.id.btnLoad);
        nameEat = findViewById(R.id.nameEat);
        descriptionEat = findViewById(R.id.descriptionEat);
        photoEat = findViewById(R.id.photoEat);
        btnloadphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    photoEat.setImageBitmap(bitmap);
                }
        }
    }

    public void btnSave_click(View view) {
        MainActivity.eats.add(new Eat(nameEat.getText().toString(),descriptionEat.getText().toString(),bitmap));
        MainActivity.eatAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}