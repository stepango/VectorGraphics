package com.elegion.VectorGraphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by stepan.goncharov on 04.10.13.
 */
public class BitmapFragment extends BaseFragment {

  @Override
  public void onActivityCreated(final Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    byte[] array = getArguments().getByteArray("BITMAP");
    Bitmap bitmap = BitmapFactory.decodeByteArray(array, 0, array.length);
    getActivity().getActionBar().setTitle("Bitmap");
    ImageView svgImageView = new ImageView(getActivity()) {
      @Override
      protected void onDraw(final Canvas canvas) {
        final long time = System.nanoTime();
        super.onDraw(canvas);
        reportDrawDuration(System.nanoTime() - time);
      }
    };
    svgImageView.setImageDrawable(new BitmapDrawable(getResources(), bitmap));
    addViewToSvgArea(svgImageView);
    getView().findViewById(R.id.btn_show_as_bitmap).setVisibility(View.GONE);
  }
}
