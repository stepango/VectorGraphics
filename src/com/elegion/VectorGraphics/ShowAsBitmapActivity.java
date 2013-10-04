package com.elegion.VectorGraphics;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by stepan.goncharov on 04.10.13.
 */
public class ShowAsBitmapActivity extends Activity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      setContentView(R.layout.activity_show);
      Bundle extras = getIntent().getExtras();
      Fragment fragment = Fragment.instantiate(this, BitmapFragment.class.getName());
      fragment.setArguments(extras);
      getFragmentManager().beginTransaction().add(R.id.root, fragment).commit();
    }
  }

}
