package com.elegion.VectorGraphics;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by IntelliJ IDEA.
 * User: sone
 * Date: 27.08.13
 * Time: 0:05
 */
public class ShowActivity extends Activity {

  @Override
  protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (savedInstanceState == null) {
      setContentView(R.layout.activity_show);
      Bundle extras = getIntent().getExtras();
      final String name = extras.getString(MainActivity.EXTRA_FRAGMENT_NAME);
      Fragment fragment = Fragment.instantiate(this, name);
      fragment.setArguments(extras);
      getFragmentManager().beginTransaction().add(R.id.root, fragment).commit();
    }
  }
}
