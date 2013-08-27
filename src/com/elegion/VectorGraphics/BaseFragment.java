package com.elegion.VectorGraphics;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by sone on 22.08.13.
 */
public class BaseFragment extends Fragment {

  private static final int[] TESTS = new int[]{
      R.raw.acid1, R.raw.drama, R.raw.lion, R.raw.tiger,
      R.raw.acid1_opt, R.raw.drama_opt, R.raw.lion_opt, R.raw.tiger_opt,
      R.raw.knot
  };

  protected int[] getTestsArray() {
    return TESTS;
  }

  protected int getSvgId() {
    return getTestsArray()[getArguments().getInt(MainActivity.EXTRA_TEST_NUM)];
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    if (container == null) {
      return null;
    }
    return new FrameLayout(getActivity());
  }
}
