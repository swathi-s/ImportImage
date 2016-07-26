package com.example.user.importimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Car> myCars = new ArrayList<Car>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateCarList();
        populateListView();
    }

    private void populateCarList() {
        myCars.add(new Car("Ford",1940,R.drawable.ford,"Needing work"));
        myCars.add(new Car("Toyoto",1994,R.drawable.toyoto,"Lovable"));
        myCars.add(new Car("Honda",1999,R.drawable.honda,"Wet"));
        myCars.add(new Car("Porche",2005,R.drawable.porche,"Fast!"));
        myCars.add(new Car("Jeep",200,R.drawable.jeep,"Awesome"));
        myCars.add(new Car("Rust-Bucket",2010,R.drawable.rust_bucket,"Not very good"));
        myCars.add(new Car("Moon Lander",1971,R.drawable.moon_lander,"Out of this world"));
    }

    private void populateListView() {
        ArrayAdapter<Car> adapter = new MyListAdapter();
        ListView list = (ListView) findViewById(R.id.carsListView);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Car>{
        public MyListAdapter() {
            super(MainActivity.this,R.layout.item_view, myCars);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Make sure we hava a view to work with (may have been given null
            View itemView = convertView;
            if(itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.item_view,parent,false);
            }

            //find the car to work with
            Car currentCar = myCars.get(position);

            //Fill the view
            ImageView imageView = (ImageView) itemView.findViewById(R.id.item_icon);

            imageView.setImageResource(currentCar.getIconID());

            TextView txtMake = (TextView) itemView.findViewById(R.id.txtMake);
            txtMake.setText(currentCar.getMake());

            TextView txtYear = (TextView) itemView.findViewById(R.id.txtYear);
            txtYear.setText("" + currentCar.getYear());

            TextView txtCondition = (TextView) itemView.findViewById(R.id.txtCondition);
            txtCondition.setText(currentCar.getCondition());
            return itemView;
            //return super.getView(position,convertView,parent);
        }
    }
}
