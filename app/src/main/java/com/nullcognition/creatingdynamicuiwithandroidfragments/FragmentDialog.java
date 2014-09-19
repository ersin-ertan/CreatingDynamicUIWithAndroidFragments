package com.nullcognition.creatingdynamicuiwithandroidfragments;

import android.app.Activity;
import android.os.Bundle;

//	in displaying class
//	MyDialogFragment theDialog = new MyDialogFragment();
//  theDialog.show(getFragmentManager(), null);

public class FragmentDialog extends android.app.DialogFragment implements android.view.View.OnClickListener { // 3 parts: layout, title, frame


  private OnDialogFragmentInteractionListener mListener;

  public FragmentDialog(){}

  public static FragmentDialog newInstance(){
	FragmentDialog fragment = new FragmentDialog();
	return fragment;
  }

//  @Override
//  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//	View textView = inflater.inflate(android.R.layout.select_dialog_multichoice, container, false); //input custom layout for dialog
//
//	// Connect the Yes button click event and request focus
//	View yesButton = textView.findViewById(R.id.btnYes);
//	yesButton.setOnClickListener(this);
//	yesButton.requestFocus();
//// Connect the No button click event
//	View noButton = textView.findViewById(R.id.btnNo);
//	n oButton.setOnClickListener(this);
//	return textView;
//  }
//

  @Override
  public void onAttach(Activity activity){
	super.onAttach(activity);
	try{
	  mListener = (OnDialogFragmentInteractionListener)activity;
	}
	catch(ClassCastException e){
	  throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
	}
  }

  @Override
  public void onDetach(){
	super.onDetach();
	mListener = null;
  }

  @Override
  public void onCreate(Bundle savedInstanceState){
	super.onCreate(savedInstanceState);
	setStyle(android.app.DialogFragment.STYLE_NORMAL, 0); // STYLE_NO_TITLE, STYLE_NO_INPUT,  STYLE_NO_FRAME
  }

  @Override
  public void onClick(android.view.View v){
	switch(v.getId()){
	  case com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.btnYes:

		break;
	  case com.nullcognition.creatingdynamicuiwithandroidfragments.R.id.btnNo:

		break;
	  default:
		android.util.Log.e("Switch v", "Default parameter invalid");
		throw new java.security.InvalidParameterException();
	}
  }

  public void onButtonPressed(int buttonPressed){
	if(mListener != null){
	  mListener.onDialogFragmentInteraction(buttonPressed);
	}
  }

  public interface OnDialogFragmentInteractionListener {

	public void onDialogFragmentInteraction(int buttonPressed);
  }

}
