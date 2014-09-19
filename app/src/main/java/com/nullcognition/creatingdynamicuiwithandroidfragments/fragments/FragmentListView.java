package com.nullcognition.creatingdynamicuiwithandroidfragments.fragments;
public class FragmentListView extends android.app.ListFragment {

//  private static final String POSITIVE_KEY = "positive";
//  private int idPositive;

  private com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.OnListFragmentItemInteractionListener fragmentListViewItemInteractionListener;

  public FragmentListView(){}

  public static com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView newInstance(){
	com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView fragment = new com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView();
	android.os.Bundle args = new android.os.Bundle();
//	args.putInt(POSITIVE_KEY, inTextIdPositive);
	return fragment;
  }

  @Override
  public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState){
	int layoutWeight = 1;
	if(getArguments() != null){
	  layoutWeight = getArguments().getInt("layoutWeight", 1);
	  container.setLayoutParams(new android.widget.LinearLayout.LayoutParams(0, android.widget.LinearLayout.LayoutParams.MATCH_PARENT, layoutWeight));
	}
	return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override
  public void onListItemClick(android.widget.ListView inListView, android.view.View inView, int inPosition, long inId){
	super.onListItemClick(inListView, inView, inPosition, inId);
	if(null != fragmentListViewItemInteractionListener){
	  fragmentListViewItemInteractionListener.onFragmentListViewItemInteraction(inPosition);
	}
  }

  @Override
  public void onAttach(android.app.Activity activity){
	super.onAttach(activity);
	try{
	  fragmentListViewItemInteractionListener = (com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentListView.OnListFragmentItemInteractionListener)activity;
	}
	catch(ClassCastException e){
	  throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
	}
  }

  @Override
  public void onCreate(android.os.Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	if(getArguments() != null){
//	  idPositive = getArguments().getInt(POSITIVE_KEY);
	}
	setListsListAdapter();
  }

  private void setListsListAdapter(){ // change this based on the adapter used
	String[] listViewTextArray = getResources().getStringArray(com.nullcognition.creatingdynamicuiwithandroidfragments.R.array.listview_stringaray);
	setListAdapter( // public static HashMap used below
					new android.widget.ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1,
															listViewTextArray));
  }

  @Override
  public void onDetach(){
	super.onDetach();
	fragmentListViewItemInteractionListener = null;
  }

  public interface OnListFragmentItemInteractionListener {

	public void onFragmentListViewItemInteraction(int inPosition);
  }

}
