package com.reverserecipebook.tabs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import com.reverserecipebook.R;

public class RecipeSearchFragment extends SherlockFragment
{
   private static final CharSequence[] ADD_METHODS = { "Browse", "Search", "From My Pantry", "Scan" };
   private static final int BROWSE = 0;
   private static final int SEARCH = 1;
   private static final int MYPANTRY = 2;
   private static final int SCAN = 3;
   
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      // We have a menu item to show in action bar.

      setHasOptionsMenu(true);
   }

   @Override
   public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
   {
      // TODO Auto-generated method stub
      super.onCreateOptionsMenu(menu, inflater);

      inflater.inflate(R.menu.optionsmenu_recipesearch, menu);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      switch (item.getItemId()) {
         case R.id.optionsmenu_recipesearch_add:
            Toast.makeText(getSherlockActivity(), "Add", Toast.LENGTH_SHORT);
            SherlockDialogFragment frag = AddDialogFragment.newInstance();
            frag.show(getFragmentManager(), "add");
            break;
         case R.id.optionsmenu_recipesearch_options:
            Toast.makeText(getSherlockActivity(), "Options", Toast.LENGTH_SHORT);
            break;
         case R.id.optionsmenu_recipesearch_clear:
            Toast.makeText(getSherlockActivity(), "Clear", Toast.LENGTH_SHORT);
            break;
         case R.id.optionsmenu_recipesearch_go:
            Toast.makeText(getSherlockActivity(), "Go", Toast.LENGTH_SHORT);
            break;
      }

      return true;
   }

   /**
    * The DialogFragment that shows when the "Add" Action Item is selected.
    */
   public static class AddDialogFragment extends SherlockDialogFragment
   {
      public static AddDialogFragment newInstance()
      {
         return new AddDialogFragment();
      }

      @Override
      public void onCreate(Bundle savedInstanceState)
      {
         super.onCreate(savedInstanceState);
      }

      @Override
      public Dialog onCreateDialog(Bundle savedInstanceState)
      {
         return new AlertDialog.Builder(getActivity())
               //.setIcon(R.drawable.alert_dialog_icon)
               .setTitle("Add an Item").setItems(ADD_METHODS, new DialogInterface.OnClickListener()
               {
                  @Override
                  public void onClick(DialogInterface dialog, int which)
                  {
                     switch (which) {
                        case BROWSE:
                           break;
                        case SEARCH:
                           break;
                        case MYPANTRY:
                           break;
                        case SCAN:
                           break;
                     }
                  }
               }).create();
      }
   }
}