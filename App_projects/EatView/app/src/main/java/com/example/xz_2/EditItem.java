package com.example.xz_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class EditItem extends AppCompatActivity {
    static final int GALLERY_REQUEST = 1;
    private EditText nameEat;
    private EditText descriptionEat;
    private ImageView photoEat;

    private String name;
    private String description;
    private int photo;
    private int index;
    private Button btnloadphoto;
    private Bitmap bitmap = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);
        nameEat = findViewById(R.id.nameEat);
        descriptionEat = findViewById(R.id.descriptionEat);
        photoEat = findViewById(R.id.photoEat);
        name = MainActivity.eats.get(index).getName();
        description  = MainActivity.eats.get(index).getDsctiption();
        nameEat.setText(name);
        descriptionEat.setText(description);
        if(MainActivity.eats.get(index).getEatResource() != 0 )
            photoEat.setImageResource(MainActivity.eats.get(index).getEatResource());
        else
            photoEat.setImageBitmap(MainActivity.eats.get(index).getBitmap());
        if(MainActivity.eats.get(index).getBitmap() != null){
            bitmap = MainActivity.eats.get(index).getBitmap();
        }
        btnloadphoto = findViewById(R.id.btnLoad);
        btnloadphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
            }
        });
    }
    @Override
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
        if(bitmap != null){
            Eat eat = new Eat(nameEat.getText().toString(), descriptionEat.getText().toString(), bitmap);
            MainActivity.eats.set(MainActivity.position1,eat);
            MainActivity.eatAdapter.notifyDataSetChanged();
        }
        else {
            Eat eat = new Eat(nameEat.getText().toString(), descriptionEat.getText().toString(), index);
            MainActivity.eats.set(MainActivity.position1,eat);
            MainActivity.eatAdapter.notifyDataSetChanged();
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void btnRemove_click(View view) {
        MainActivity.eats.remove(MainActivity.position1);
        MainActivity.eatAdapter.notifyItemRemoved(MainActivity.position1);
        MainActivity.eatAdapter.notifyItemRangeChanged(MainActivity.position1, MainActivity.eats.size());
        MainActivity.eatAdapter.notifyDataSetChanged();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}