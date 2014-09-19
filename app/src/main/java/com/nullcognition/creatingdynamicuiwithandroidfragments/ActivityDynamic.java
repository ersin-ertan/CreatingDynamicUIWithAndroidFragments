package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ActivityDynamic extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_dynamic);
	android.app.FragmentManager fragmentManager = getFragmentManager();
	android.app.FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();

	android.app.Fragment fragmentDynamic = fragmentManager
	  .findFragmentById(com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.fragment_dynamic);
	android.app.Fragment fragmentDynamicWide = fragmentManager
	  .findFragmentById(com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.fragment_dynamic_wide);

	if(fragmentDynamic != null){loadPortraitLayout(fragmentDynamic);}
	else if(fragmentDynamicWide != null){loadLandscapLayout(fragmentDynamicWide);}
	else{ android.util.Log.e(getClass().getSimpleName(), "activityDynamic oncreate fragmentdynamic, wide both null"); }
  }

  private void loadPortraitLayout(android.app.Fragment inFragment){
  }

  private void loadLandscapLayout(android.app.Fragment inFragment){ // activity_dynamic_wide
	android.app.FragmentManager fragmentManager = getFragmentManager();
	android.app.FragmentTransaction fragmentTrasaction = fragmentManager.beginTransaction();

	android.view.ViewGroup viewGroupOfFragment = (android.view.ViewGroup)inFragment.getView().getParent();

	fragmentTrasaction.addToBackStack(null);
	fragmentTrasaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

	android.app.Fragment fragmentListView = com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.newInstance();
	Bundle bundle = new android.os.Bundle();
	bundle.putInt("fragmentLayoutWeight", 2);
	fragmentListView.setArguments(bundle);
	fragmentTrasaction.add(viewGroupOfFragment.getId(), fragmentListView, "FragmentListView");

	fragmentTrasaction.commit();
	fragmentManager.executePendingTransactions();


  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu){
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.activity_dynamic, menu);
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
}
