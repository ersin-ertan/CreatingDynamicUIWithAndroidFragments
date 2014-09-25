package com.nullcognition.creatingdynamicuiwithandroidfragments;
/**
 * Created by ersin on 22/09/14 at 6:42 PM
 */
public class SimpleTabListener implements android.app.ActionBar.TabListener {


  boolean mFirstSelect = true;
  android.app.Fragment mFragment;

  public SimpleTabListener(android.app.Fragment fragment){
	mFragment = fragment;
  }


  @Override
  public void onTabSelected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction){
	if(mFirstSelect){
	  fragmentTransaction.add(android.R.id.content, mFragment);
	  mFirstSelect = false;
	}
	else{ fragmentTransaction.attach(mFragment); }
  }

  @Override
  public void onTabUnselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft){
	ft.detach(mFragment);
  }

  @Override
  public void onTabReselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft){
	// if doing dual screen nav on the double selection
  }
}
