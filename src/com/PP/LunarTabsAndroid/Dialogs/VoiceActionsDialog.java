package com.PP.LunarTabsAndroid.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.PP.LunarTabsAndroid.APIs.WordActivatorAPI;
import com.PP.LunarTabsAndroid.UI.DataModel;
import com.PP.LunarTabsAndroid.UI.ResourceModel;
import com.example.lunartabsandroid.R;

public class VoiceActionsDialog extends DialogFragment {
	
	//menu item to relabel
	protected MenuItem menuItem;
	
	public VoiceActionsDialog(MenuItem menuItem) {
		this.menuItem = menuItem;
	}
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.VoiceActionsText)
        	   .setTitle(R.string.VoiceActionsTitle)
               .setPositiveButton(R.string.VoiceActionsYes, new DialogInterface.OnClickListener() {
                   @Override
				public void onClick(DialogInterface dialog, int id) {
                	   
                	   //start voice actions
                	   DataModel.getInstance().setVoiceActionsEnabled(true);
                	   WordActivatorAPI.getInstance().start();
                	   
                	   //relabel menu item
                	   menuItem.setTitle(ResourceModel.getInstance().DISABLE_VOICE_ACTIONS);
                	   
                   }
               })
               .setNegativeButton(R.string.VoiceActionsNo, new DialogInterface.OnClickListener() {
                   @Override
				public void onClick(DialogInterface dialog, int id) {
                	   
                   }
               });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}