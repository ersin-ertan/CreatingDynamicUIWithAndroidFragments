package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivitySwipe extends android.support.v4.app.FragmentActivity {

  com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.DetailPagerAdapter detailPagerAdapter;
  android.support.v4.view.ViewPager                                                    viewPager;

  String[] details = null;

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_swipe);

	details = getResources().getStringArray(com.nullcognition.creatingdynamicuiwithandroidfragments.R.array.detail_stringaray);

	detailPagerAdapter = new com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.DetailPagerAdapter(getFragmentManager());
	viewPager = (android.support.v4.view.ViewPager)findViewById(R.id.pager);
	viewPager.setAdapter(detailPagerAdapter);


  }


  @Override
  public boolean onCreateOptionsMenu(Menu menu){
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_swipe, menu);
	return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	//noinspection SimplifiableIfStatement
	if(id == R.id.action_settings){
	  android.content.Intent ActivityTabs = new android.content.Intent(this,
																	   com.nullcognition.creatingdynamicuiwithandroidfragments.ActivityTabs.class);
	  startActivity(ActivityTabs);

	  return true;
	}

	return super.onOptionsItemSelected(item);
  }

}
