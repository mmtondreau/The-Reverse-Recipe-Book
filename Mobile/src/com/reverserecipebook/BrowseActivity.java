package com.reverserecipebook;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

public class BrowseActivity extends SherlockActivity
{
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      
      getSupportActionBar().setTitle(getString(R.string.name_browse));   
      
      // Causes onCreateOptionsMenu to be called
      //this.invalidateOptionsMenu();
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu)
   {
      // TODO Auto-generated method stub
      MenuInflater inflater = getSupportMenuInflater();
      inflater.inflate(R.menu.optionsmenu_browse, menu);
      return true;
   }
}
