package tris.parkingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Home extends AppCompatActivity {
String array[]= {"vinod ","sharma ","kumar",""};
ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        MyAdapter adapter = new MyAdapter(this);
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

    }

    class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(@NonNull Context context) {
            super(context, R.layout.customlistview, R.id.listview, array);
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View vv = convertView;
            MyViewHolder holder = null;
            if (vv == null) {
                vv = getLayoutInflater().inflate(R.layout.customlistview, parent, false);
                holder = new MyViewHolder(vv);
            }
            return vv;
        }
        class MyViewHolder {
            TextView tv1,tv2;
            public MyViewHolder(View vv){
            }
        }
    }
    }


