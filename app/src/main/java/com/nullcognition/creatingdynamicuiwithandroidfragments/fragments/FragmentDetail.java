package com.nullcognition.creatingdynamicuiwithandroidfragments.fragments;
public class FragmentDetail extends android.app.Fragment {

  public static final String textViewKey = "adftv_key";
  android.widget.TextView textView = null;

  String s;

  public FragmentDetail(){}

  public static com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail newInstance(){

	com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail fragmentDetail = new com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.FragmentDetail();
	//fragmentDetail.setArguments(new android.os.Bundle());
	return fragmentDetail;
  }

  @Override
  public void onViewCreated(android.view.View view, android.os.Bundle savedInstanceState){
	super.onViewCreated(view, savedInstanceState);
	setDetailText(s);

  }

  @Override
  public android.view.View onCreateView(android.view.LayoutInflater inflater, android.view.ViewGroup container, android.os.Bundle savedInstanceState){
	super.onCreateView(inflater, container, savedInstanceState);


	android.view.View rootView = inflater
	  .inflate(com.nullcognition.creatingdynamicuiwithandroidfragments.R.layout.fragment_detail_layout, container, false);

	s = getArguments().getString(com.nullcognition.creatingdynamicuiwithandroidfragments.fragments.DetailPagerAdapter.BOOK_TITLE);

	return rootView;
  }

  public void setDetailText(String inString){

	textView = (android.widget.TextView)getView().findViewById(com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.textView_detail_layout);
	if(textView != null){ textView.setText(inString); }
	else{ android.util.Log.e(getClass().getSimpleName(), "fragmentwithlayout.setDetailtext error"); }
  }
}
