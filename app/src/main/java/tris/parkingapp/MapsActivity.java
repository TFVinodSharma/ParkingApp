package tris.parkingapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    String[] parkingTitles;
    String[] parkingDescription;

    private GoogleMap mMap;
    String array[] = {"vinod ", "sharma ", "kumar"};
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Resources res = getResources();// this method returns the object type.

        parkingTitles = res.getStringArray(R.array.title);
        parkingDescription = res.getStringArray(R.array.Description);

        MyAdapter adapter = new MyAdapter(this, parkingTitles, parkingDescription);
        list = findViewById(R.id.listview);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MapsActivity.this, Details.class);
                intent.putExtra("title", list.getItemAtPosition(i).toString());
                startActivity(intent);
            }
        });


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String[] titleArray;
        String[] descriptionArray;

        public MyAdapter(@NonNull Context context, String[] titles, String[] desc) {
            super(context, R.layout.customlistview, R.id.listview, array);
            this.context = context;
            this.titleArray = titles;
            this.descriptionArray = desc;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View vv = convertView;
            Home.MyAdapter.MyViewHolder holder = null;
            if (vv == null) {
                vv = getLayoutInflater().inflate(R.layout.customlistview, parent, false);

                TextView myTitles = vv.findViewById(R.id.textview1);
                TextView myDescription = vv.findViewById(R.id.textview2);

                myTitles.setText(titleArray[position]);
                myDescription.setText(descriptionArray[position]);

            }
            return vv;
        }


    }
}
