package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivityMain extends Activity implements com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.OnListFragmentItemInteractionListener {

  boolean                                                                          isMultiFragment = false; // for either portrait or landscape
  com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail fragmentDetail  = null;

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

  }

  @Override
  protected void onStart(){
	super.onStart();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_main, menu);
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

  @Override
  public void onFragmentListViewItemInteraction(int inPosition){

	fragmentDetail = (com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail)getFragmentManager()
	  .findFragmentById(com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.fragmentDetail_activity_main);

	String[] details = getResources().getStringArray(com.nullcognition.creatingdynamicuiwithandroidfragments.R.array.detail_stringaray);

	if(fragmentDetail != null && fragmentDetail.isAdded()){

	  isMultiFragment = true;

	  fragmentDetail.setDetailText(details[inPosition]);
	}
	else if(fragmentDetail == null){

	  isMultiFragment = false;

	  android.content.Intent startActivityDetail = new android.content.Intent(this, ActivityDetail.class);
	  startActivityDetail.putExtra(com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail.textViewKey, details[inPosition]);
	  startActivity(startActivityDetail);
	}
  }
}
