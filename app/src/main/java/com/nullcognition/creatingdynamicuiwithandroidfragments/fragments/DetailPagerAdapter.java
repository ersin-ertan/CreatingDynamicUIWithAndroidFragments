package com.nullcognition.creatingdynamicuiwithandroidfragments.fragments;
/**
 * Created by ersin on 22/09/14 at 5:04 PM
 */
public class DetailPagerAdapter extends android.support.v13.app.FragmentPagerAdapter {


  private String[] mCourseTitles = {"aaa", "bbbb", "cccc"};
  private CharSequence[] mCourseTitlesShort = {"a", "b", "c"};

  public static String BOOK_TITLE = "bookTitles";
  public static String TOP_IMAGE  = "topImage";

  private int[] mTopImageResourceIds = {android.R.drawable.arrow_up_float, android.R.drawable.arrow_down_float, android.R.drawable.btn_minus};

  public DetailPagerAdapter(android.app.FragmentManager fm){
	super(fm);
  }

  @Override
  public android.app.Fragment getItem(int idx){

	if((idx > mCourseTitles.length - 1) || idx < 0) android.util.Log.e(getClass().getSimpleName(), "Error invalid input parameters");

	android.os.Bundle arguments = new android.os.Bundle();

	arguments.putString(BOOK_TITLE, mCourseTitles[idx]);
	arguments.putInt(TOP_IMAGE, mTopImageResourceIds[idx]);

	FragmentDetail fragmentDetail = new FragmentDetail();
	fragmentDetail.setArguments(arguments);
	return fragmentDetail;
  }

  @Override
  public int getCount(){
	return mCourseTitles.length;
  }

  public CharSequence getPageTitle(int idx) {
	return mCourseTitlesShort[idx];
  }
}
