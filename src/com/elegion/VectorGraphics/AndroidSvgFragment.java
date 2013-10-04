package com.elegion.VectorGraphics;


import android.graphics.Canvas;
import android.os.Bundle;
import com.caverock.androidsvg.SVGImageView;


/**
 * Created by sone on 18.08.13.
 */
public class AndroidSvgFragment extends BaseFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getActivity().getActionBar().setTitle("AndroidSvg");
    try {
      SVGImageView svgImageView = new SVGImageView(getActivity()){
        @Override
        protected void onDraw(final Canvas canvas) {
          final long time = System.nanoTime();
          super.onDraw(canvas);
          reportDrawDuration(System.nanoTime() - time);
        }
      };
      svgImageView.setImageResource(getSvgId());
      addViewToSvgArea(svgImageView);
    } catch (NullPointerException e) {
      e.printStackTrace();
      //Known bug https://code.google.com/p/androidsvg/issues/detail?id=13&can=1
    }
  }


}
