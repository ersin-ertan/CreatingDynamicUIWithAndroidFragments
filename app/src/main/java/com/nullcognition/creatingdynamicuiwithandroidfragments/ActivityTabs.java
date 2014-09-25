package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivityTabs extends Activity implements android.app.ActionBar.TabListener,
													  android.app.ActionBar.OnNavigationListener {

  boolean actionBarTabsListToggle = true;

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_tabs);
	setUpTabs();
  }

  protected void setUpTabs(){
	// Put ActionBar in Tab mode
	android.app.ActionBar actionBar = getActionBar();
	actionBar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
// Create the first tab
	actionBar.addTab(actionBar.newTab().setText("first").setTabListener(this));
	actionBar.addTab(actionBar.newTab().setText("second").setTabListener(this));

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_tabs, menu);
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
	  if(actionBarTabsListToggle == true){
		setUpList();
		actionBarTabsListToggle = false;
	  }
	  else if(actionBarTabsListToggle == false){
		setUpTabs();
		actionBarTabsListToggle = true;
	  }

	  return true;
	}

	return super.onOptionsItemSelected(item);
  }

  protected void setUpList(){

	getActionBar().setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_LIST);
	getActionBar().setDisplayShowTitleEnabled(false);

	String[] screenNames = getResources().getStringArray(com.nullcognition.creatingdynamicuiwithandroidfragments.R.array.detail_stringaray);

	android.widget.ArrayAdapter<String> adapter = new android.widget.ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, screenNames);
// Create the Listener and associate with the ActionBar
	android.app.ActionBar.OnNavigationListener listener = this;
	getActionBar().setListNavigationCallbacks(adapter, listener);
  }

  @Override
  public void onTabSelected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction fragmentTransaction){

	android.app.Fragment fragment = new DummySectionFragment();
	Bundle args = new Bundle();
	args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, tab.getPosition() + 1);
	fragment.setArguments(args);
	getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
  }

  @Override
  public void onTabUnselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft){

  }

  @Override
  public void onTabReselected(android.app.ActionBar.Tab tab, android.app.FragmentTransaction ft){
	// if doing dual screen nav on the double selection
  }

  @Override
  public boolean onNavigationItemSelected(int itemPosition, long itemId){
	android.app.Fragment fragment = null;
	Bundle b = new android.os.Bundle();
	switch(itemPosition){
	  case 0:
		fragment = new com.nullcognition.creatingdynamicuiwithandroidfragments.ActivityTabs.DummySectionFragment();
		b.putInt(com.nullcognition.creatingdynamicuiwithandroidfragments.ActivityTabs.DummySectionFragment.ARG_SECTION_NUMBER, 4);
		break;
	  case 1:
		fragment = new com.nullcognition.creatingdynamicuiwithandroidfragments.ActivityTabs.DummySectionFragment();
		b.putInt(com.nullcognition.creatingdynamicuiwithandroidfragments.ActivityTabs.DummySectionFragment.ARG_SECTION_NUMBER, 5);
		break;
	  case 2:
		break;
	  case 3:
		break;
	  case 4:
		break;
	  default:
		android.util.Log.e("Switch itemPosition", "Default parameter invalid");
		throw new java.security.InvalidParameterException();
	}

	if(fragment != null){
	  fragment.setArguments(b);
	  getFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
	}

	return true;
  }

  public static class DummySectionFragment extends android.app.Fragment {

	public static final String ARG_SECTION_NUMBER = "placeholder_text";

	@Override
	public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState){
	  android.widget.TextView textView = new android.widget.TextView(getActivity());
	  textView.setGravity(android.view.Gravity.CENTER);
	  textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
	  return textView;
	}
  }
}
