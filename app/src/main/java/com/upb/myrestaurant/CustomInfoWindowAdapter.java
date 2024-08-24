package com.upb.myrestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class CustomInfoWindowAdapter implements GoogleMap.InfoWindowAdapter {

    private final View mWindow;
    private Context mContext;

    public CustomInfoWindowAdapter(Context context) {
        mContext = context;
        mWindow = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);
    }

    private void renderWindowText(Marker marker, View view) {
        String title = marker.getTitle();
        TextView tvTitle = view.findViewById(R.id.title);

        if (title != null && !title.equals("")) {
            tvTitle.setText(title);
        }

        String snippet = marker.getSnippet();
        TextView tvSnippet = view.findViewById(R.id.snippet);

        if (snippet != null && !snippet.equals("")) {
            tvSnippet.setText(snippet);
        }

        ImageView imageView = view.findViewById(R.id.image);
        switch (title) {
            case "Voraz Laureles":
                imageView.setImageResource(R.drawable.voraz_laureles);
                break;
            case "Voraz U.P.B":
                imageView.setImageResource(R.drawable.voraz_upb);
                break;
            case "Voraz Provenza":
                imageView.setImageResource(R.drawable.voraz_provenza);
                break;
            case "Voraz Palmas":
                imageView.setImageResource(R.drawable.voraz_palmas);
                break;
            default:
                imageView.setImageResource(R.drawable.voraz_logo);
                break;
        }
    }

    @Override
    public View getInfoWindow(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }

    @Override
    public View getInfoContents(Marker marker) {
        renderWindowText(marker, mWindow);
        return mWindow;
    }
}
