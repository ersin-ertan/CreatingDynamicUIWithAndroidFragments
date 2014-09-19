package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivitySwipe extends android.support.v4.app.FragmentActivity {

  String[] details = null;

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_swipe);
	details = getResources().getStringArray(com.nullcognition.creatingdynamicuiwithandroidfragments.R.array.detail_stringaray);
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
	  return true;
	}

	return super.onOptionsItemSelected(item);
  }

  public static class PageAdapter extends android.support.v13.app.FragmentPagerAdapter {

	private static final String fragmentContentKey = "content";

	public PageAdapter(android.app.FragmentManager fm){
	  super(fm);
	}

	@Override
	public android.app.Fragment getItem(int inId){
	  // create pack item with contents of a source based on the id

	  Bundle bundle = new android.os.Bundle();
	 // bundle.putString("content", details[inId]); // this is the line where we decide to pass in the the data as

	  return null;
	}

	@Override
	public int getCount(){
	  return 0;
	}
  }

  public static class FragmentPlain extends android.app.Fragment {

	private static final String id_number = "fragmentPlainIdNumber";

	public FragmentPlain(){}

	public static FragmentPlain newInstance(int inId){
	  FragmentPlain fragment = new FragmentPlain();

	  Bundle args = new Bundle();
	  args.putInt(id_number, inId);
	  fragment.setArguments(args);

	  return fragment;
	}

	@Override
	public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState){
	  android.view.View rootView = inflater.inflate(R.layout.fragment_plain, container, false); return rootView;
	}
  }
}
