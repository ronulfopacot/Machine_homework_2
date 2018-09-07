package com.pacot.myapplication;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PlanetAdapter extends ArrayAdapter<Planets> {

    private Context context;
    private int itemLayoutResource;
    private ArrayList<Planets> planets = new ArrayList<>();

    public PlanetAdapter(@NonNull Context context, int resource, @NonNull List<Planets> planets) {
        super(context, resource, planets);

        this.context = context;
        this.itemLayoutResource = resource;
        this.planets.addAll(planets);
    }

    @Nullable
    @Override
    public Planets getItem(int position) {
        return this.planets.get(position);
    }

    @Override
    public int getCount() {
        return this.planets.size();
    }

    @Override
    public int getPosition(@Nullable Planets item) {
        return this.planets.indexOf(item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planets planet = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View planetItemLayout = inflater.inflate(itemLayoutResource, parent, false);

        ImageView planetImageView = planetItemLayout.findViewById(R.id.planet_imageView);
        TextView planetname = planetItemLayout.findViewById(R.id.planet_title_textView);
        TextView planetdiameter = planetItemLayout.findViewById(R.id.planet_diameter);
        TextView planetstatus = planetItemLayout.findViewById(R.id.planet_status);

        if(planet.getName() != null){
            planetname.setText(planet.getName());
        }
        if(planet.getDiameter() != null){
            planetdiameter.setText(planet.getDiameter());
        }
        if(planet.getStatus() != null){
            planetstatus.setText(planet.getStatus());
        }
        if(planet.getImageFileName() != null){
            try {
                Bitmap bitmap = getBitmapFromAssets(context, planet.getImageFileName());

                planetImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return planetItemLayout;
    }

    public Bitmap getBitmapFromAssets(Context context, String fileName) throws IOException {
        AssetManager assetManager = context.getAssets();

        InputStream walop = assetManager.open(fileName);
        Bitmap bitmap = BitmapFactory.decodeStream(walop);

        return bitmap;
    }
}
