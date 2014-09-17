package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivityDetail extends Activity implements com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.OnListFragmentItemInteractionListener {

  String detailText = null;

  // FragmentTransaction.TRANSIT_FRAGMENT_OPEN, _CLOSE, _NONE, are the same as opening an activity and closing, pre 'l' activity transitions
  // note, custom fragment transaction may be used instead of using the animator. unless granular control after an animation is done is dependant on execution of tasks

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);

	setContentView(R.layout.activity_detail);

	android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
	fragmentTransaction.setTransition(
	  android.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN); // will not show as is called in the onCreate, unless fragment is on backstack
	fragmentTransaction.add(com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.frameLayout_activity_detail,
							com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail.newInstance(),
							"fragmentDetail_activityDetail").commit();

	// Reason for dynamic fragment addition is for the add-remove / replace transaction, note that replacing a staticlly baked fragment
	// will not remove it even with the idOfContainterLayout = ((android.view.ViewGroup)fragment.getView().getParent()).getId(); to find the parent view
	// to replace or add the new fragment into

	// lesson: put widget elements into layouts, not stand alones
	// put fragments into layouts too, if doing transactions
  }


  @Override
  protected void onStart(){
	super.onStart();

	//getFragmentManager().executePendingTransactions(); // vital if in the same method of .commit()

	detailText = (String)getIntent().getExtras().get(com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail.textViewKey);

	com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail fragmentDetail = ((com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail)getFragmentManager()
	  .findFragmentByTag("fragmentDetail_activityDetail"));

	if(fragmentDetail != null){
	  fragmentDetail.setDetailText(detailText);
	}
	else{ android.util.Log.e("activityDetail", "fragment detail .setDetail text nerror due to null fragment"); }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_detail, menu);
	return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item){
	// Handle action bar item clicks here. The action bar will
	// automatically handle clicks on the Home/Up button, so long
	// as you specify a parent activity in AndroidManifest.xml.
	int id = item.getItemId();

	//noinspection SimplifiableIfStatement
	android.app.FragmentManager fragmentManager = getFragmentManager();
	if(id == R.id.action_settings){
	  if(fragmentManager.findFragmentByTag("fragmentDetail_activityDetail") != null){

		android.app.FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();
		fragmentTrasaction.setTransition(android.app.FragmentTransaction.TRANSIT_FRAGMENT_OPEN); // trying the setCustomAnimations see below

		com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail fragment = (com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail)fragmentManager
		  .findFragmentByTag("fragmentDetail_activityDetail");
		int idOfContainterLayout = ((android.view.ViewGroup)fragment.getView().getParent()).getId();

		fragmentTrasaction.addToBackStack("00");
		fragmentTrasaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

		fragmentTrasaction.add(idOfContainterLayout, com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.newInstance(),
							   "fragListViewInActivityDetail");

		fragmentTrasaction.remove(
		  fragment); // stick to the add remove flow as the replace should be used if there is explicitly 1 fragment in the activity as a specific
		// layout to remove the fragment from is not specified so the removal is not exacting

		fragmentTrasaction.commit();
	  }

	  return true;
	}

	return super.onOptionsItemSelected(item);
  }

  @Override
  public void onFragmentListViewItemInteraction(int inPosition){
	android.widget.Toast.makeText(this, "you clicked on " + Integer.toString(inPosition), android.widget.Toast.LENGTH_SHORT).show();

  }
}
