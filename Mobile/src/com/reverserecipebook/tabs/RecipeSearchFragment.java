package com.reverserecipebook.tabs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.app.SherlockListFragment;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

import com.reverserecipebook.BrowseActivity;
import com.reverserecipebook.R;
import com.reverserecipebook.ReverseRecipeCookbookActivity;

public class RecipeSearchFragment extends SherlockListFragment
{
   private static final CharSequence[] ADD_METHODS = { "Browse", "From My Pantry", "Scan Barcode" };
   private static final int BROWSE = 0;
   private static final int MYPANTRY = 1;
   private static final int SCAN = 2;

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
      super.onCreateOptionsMenu(menu, inflater);

      inflater.inflate(R.menu.optionsmenu_recipesearch, menu);
   }

   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
   {
      return inflater.inflate(R.layout.itemlist_recipe, container, false);
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item)
   {
      switch (item.getItemId()) {
         case R.id.optionsmenu_recipesearch_add:
            // Toast.makeText(getSherlockActivity(), "Add", Toast.LENGTH_SHORT);
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
         // .setIcon(R.drawable.alert_dialog_icon)
               .setTitle("Add an Item").setItems(ADD_METHODS, new DialogInterface.OnClickListener()
               {
                  @Override
                  public void onClick(DialogInterface dialog, int which)
                  {
                     switch (which) {
                        case BROWSE:
                           startActivityForResult(new Intent(getActivity(), BrowseActivity.class),
                                 1); // TODO mwrosen: dont use 1
                           break;
                        case MYPANTRY:
                           ((SherlockFragmentActivity) getActivity()).getSupportActionBar()
                                 .setSelectedNavigationItem(
                                       ReverseRecipeCookbookActivity.IDX_MY_PANTRY);
                           break;
                        case SCAN:
                           break;
                     }
                  }
               }).create();
      }
   }
}