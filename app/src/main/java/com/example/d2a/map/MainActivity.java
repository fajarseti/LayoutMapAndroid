package com.example.d2a.map;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private boolean displayToast(String s) {
        displayToast("You selected Call");
        Uri number = Uri.parse("tel:085876247118");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
        return true;
    }


    public void displayMap() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
// Using the coordinates for Google headquarters.
        String data = getString(R.string.google_mtv_coord_zoom12);
//<string name="google_mtv_coord_zoom12">geo:-6.982794,110.4070402,17?z=16</string>
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void showmap(View view) {
        displayMap();
    }


    public void call(View view) {
        String message="hello";
        String phone_number="085876247118";
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phone_number));
        sendIntent.putExtra("sms_body", message);
        startActivity(sendIntent);
    }
}
