package com.elegion.VectorGraphics;

import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.grub.svg4mobile.Svg4mobileView;

/**
 * Created by sone on 18.08.13.
 */
public class Svg4MobileFragment extends BaseFragment {

  @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getActivity().getActionBar().setTitle("Svg4Mobile");
    Svg4mobileView view = new Svg4mobileView(getActivity());
    Display display = ((WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    if (display.getOrientation() == 0) { // Vertical
      view.setDisplayWidth(display.getWidth());
      view.setDisplayHeight(display.getHeight());
    } else { // Apaisado
      view.setDisplayWidth(display.getHeight());
      view.setDisplayHeight(display.getWidth());
    }

    view.setResource(getSvgId());
    view.camReset();
    ((ViewGroup) getView()).addView(view);
  }
}
