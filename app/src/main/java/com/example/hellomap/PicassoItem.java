package com.example.hellomap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
 * Created by ziyang0621 on 3/9/15.
 */
public class PicassoItem<T> implements Target {

    T mItem;

    PicassoItem(T item) {
        Log.d("test: ", "init marker");

        mItem = item;

    }

    @Override
    public int hashCode() {
        return mItem.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof PicassoItem) {
            if (((PicassoItem) o).mItem instanceof Marker) {
                Marker marker = ((Marker)((PicassoItem) o).mItem);
                return mItem.equals(marker);
            } else if (((PicassoItem) o).mItem instanceof GroundOverlay) {
                GroundOverlay groundOverlay = ((GroundOverlay)((PicassoItem) o).mItem);
                return mItem.equals(groundOverlay);
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
        Log.d("test: ", "bitmap loaded");
        if (mItem instanceof Marker) {
            ((Marker) mItem).setIcon(BitmapDescriptorFactory.fromBitmap(bitmap));

        } else if (mItem instanceof GroundOverlay) {
            ((GroundOverlay) mItem).setImage(BitmapDescriptorFactory.fromBitmap(bitmap));
        }
    }

    @Override
    public void onBitmapFailed(Drawable errorDrawable) {
        Log.d("test: ", "bitmap fail");
    }

    @Override
    public void onPrepareLoad(Drawable placeHolderDrawable) {
        Log.d("test: ", "bitmap preload");
    }
}
