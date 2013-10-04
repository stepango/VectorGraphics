package com.elegion.VectorGraphics;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;

/**
 * Created by sone on 22.08.13.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

  private TextView mTextView;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private int mUpdateDelay = 1000;

  private long timeSum = 0;
  private long reportsCount = 0;
  private long lastDrawTime = 0;
  private ViewGroup mViewGroup;
  private View mSvg;

  private Runnable mUpdateRunnable = new Runnable() {
    @Override
    public void run() {
      if (mSvg != null) mSvg.invalidate();
      if (reportsCount > 0){
        mTextView.setText("Average draw frame time: " + (timeSum / reportsCount) / 1000 + " microseconds\n" +
            "Last draw frame time: " + lastDrawTime / 1000 + " microseconds");
      }
      mHandler.postDelayed(this, mUpdateDelay);
    }
  };

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
    final View v = inflater.inflate(R.layout.fragment_main_dummy,container, false);
    mTextView = (TextView) v.findViewById(R.id.test_results);
    mViewGroup = (ViewGroup) v.findViewById(R.id.svg_area);
    mHandler.postDelayed(mUpdateRunnable, mUpdateDelay);
    v.findViewById(R.id.btn_show_as_bitmap).setOnClickListener(this);
    return v;
  }

  protected void reportDrawDuration(long nanoTime){
    if (reportsCount % 20 == 0){
      reportsCount = 0;
      timeSum = 0;
    }
    timeSum += nanoTime;
    reportsCount++;
    lastDrawTime = nanoTime;
  }

  public void addViewToSvgArea(final View view){
    mSvg = view;
    mViewGroup.addView(view);
  }

  @Override
  public void onClick(final View v) {
    if (mSvg == null || v.getContext() == null) return;
    mSvg.setDrawingCacheEnabled(true);
    Bitmap bitmap = mSvg.getDrawingCache();
    Intent i = new Intent(v.getContext(), ShowAsBitmapActivity.class);
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
    i.putExtra("BITMAP", bs.toByteArray());
    v.getContext().startActivity(i);
  }
}
