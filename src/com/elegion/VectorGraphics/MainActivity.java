package com.elegion.VectorGraphics;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {

  public static final String EXTRA_FRAGMENT_NAME = "vg.extra_fragment_name";
  public static final String EXTRA_TEST_NUM = "vg.test_num";

  private Spinner mSpinner;

  /**
   * Called when the activity is first created.
   */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    mSpinner = (Spinner) findViewById(R.id.spinner);
  }

  public void startAndroidSvg(final View v){
    startActivityWith(AndroidSvgFragment.class);
  }

  public void startSvgAndroid(final View v){
    startActivityWith(SvgAndroidFragment.class);
  }

  public void startTpSvg(final View v){
    startActivityWith(TpSvgFragment.class);
  }

  public void startSvg4Mobile(final View v){
    startActivityWith(Svg4MobileFragment.class);
  }

  private void startActivityWith(Class<? extends Fragment> fClass){
    Intent i = new Intent(this, ShowActivity.class);
    i.putExtra(EXTRA_FRAGMENT_NAME, fClass.getName());
    i.putExtra(EXTRA_TEST_NUM, mSpinner.getSelectedItemPosition());
    startActivity(i);
  }

}
