package com.example.examenvidejuegos;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.examenvidejuegos.entities.Entrenador;
import com.example.examenvidejuegos.servicies.EntrenadorService;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormEntrenadorActivity extends AppCompatActivity {

    ImageView image;
    Bitmap bitmap;
    byte[] sImage;
    Entrenador entrenador = new Entrenador();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_entrenador);

        solicitarPermisos();
        EditText edtNombres = findViewById(R.id.edtNombresEntrenador);
        EditText edtPueblo = findViewById(R.id.edtPuebloEntrenador);
        Button btnGaleria = findViewById(R.id.btnGaleria);
        Button btnCamara = findViewById(R.id.btnCamara);
        Button btnGuardar = findViewById(R.id.btnGuardar);
        image = findViewById(R.id.imgEntrenador);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://webhook.site/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EntrenadorService service = retrofit.create(EntrenadorService.class);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 101);
            }
        });

        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 102);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entrenador.setNombres(edtNombres.getText().toString());
                entrenador.setPueblo(edtPueblo.getText().toString());


                Call<Entrenador> entrenadorCall = service.postEntrenador(entrenador);
                entrenadorCall.enqueue(new Callback<Entrenador>() {
                    @Override
                    public void onResponse(Call<Entrenador> call, Response<Entrenador> response) {
                        Intent intent = new Intent(FormEntrenadorActivity.this, DetalleEntrenadorActivity.class);
                        intent.putExtra("nombres", entrenador.nombres);
                        intent.putExtra("pueblo", entrenador.pueblo);
                        intent.putExtra("imagen", entrenador.imagen);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Entrenador> call, Throwable t) {

                    }
                });
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            bitmap = (Bitmap) extras.get("data");
            image.setImageBitmap(bitmap);
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] bytes = stream.toByteArray();
            sImage = Base64.encode(bytes, Base64.DEFAULT);
            entrenador.setImagen(sImage.toString());
        }

        if(requestCode == 102 && resultCode == RESULT_OK)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            image.setImageBitmap(bitmap);
        }
    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }

    private void solicitarPermisos(){
        if(this.checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] { Manifest.permission.CAMERA }, 10001);
        }
        if(this.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] { Manifest.permission.READ_EXTERNAL_STORAGE }, 10002);
        }
    }
}