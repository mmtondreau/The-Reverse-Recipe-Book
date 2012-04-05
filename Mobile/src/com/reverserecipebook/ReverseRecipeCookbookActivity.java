package com.reverserecipebook;

import com.reverserecipebook.tabs.*;

//import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class ReverseRecipeCookbookActivity extends SherlockFragmentActivity
{
   private static final String KEY_CURTAB = "tab";

   @Override
   protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      // Notice that setContentView() is not used, because we use the root
      // android.R.id.content as the container for each fragment

      ActionBar actionBar;
      Tab tab;

      // setup action bar for tabs
      actionBar = getSupportActionBar();
      actionBar.setTitle(getString(R.string.name_app));
      actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

      tab = actionBar
            .newTab()
            .setText(R.string.name_recipe_search)
            .setTabListener(
                  new TabListener<RecipeSearchFragment>(this,
                        getString(R.string.name_recipe_search), RecipeSearchFragment.class));
      actionBar.addTab(tab);

      tab = actionBar
            .newTab()
            .setText(R.string.name_my_pantry)
            .setTabListener(
                  new TabListener<MyPantryFragment>(this, getString(R.string.name_my_pantry),
                        MyPantryFragment.class));
      actionBar.addTab(tab);

      tab = actionBar
            .newTab()
            .setText(R.string.name_favorites)
            .setTabListener(
                  new TabListener<FavoritesFragment>(this, getString(R.string.name_favorites),
                        FavoritesFragment.class));
      actionBar.addTab(tab);

      tab = actionBar
            .newTab()
            .setText(R.string.name_shopping_list)
            .setTabListener(
                  new TabListener<ShoppingListFragment>(this,
                        getString(R.string.name_shopping_list), ShoppingListFragment.class));
      actionBar.addTab(tab);

      // restore the last opened tab
      if (savedInstanceState != null && savedInstanceState.containsKey(KEY_CURTAB))
         actionBar.setSelectedNavigationItem(savedInstanceState.getInt(KEY_CURTAB));
   }

   @Override
   protected void onSaveInstanceState(Bundle outState)
   {
      super.onSaveInstanceState(outState);
      outState.putInt(KEY_CURTAB, getSupportActionBar().getSelectedNavigationIndex());
   }

   public static class TabListener<T extends SherlockFragment> implements ActionBar.TabListener
   {
      private final FragmentActivity mActivity;
      private final String mTag;
      private final Class<T> mClass;
      private final Bundle mArgs;
      private Fragment mFragment;

      public TabListener(FragmentActivity activity, String tag, Class<T> clz) {
         this(activity, tag, clz, null);
      }

      public TabListener(FragmentActivity activity, String tag, Class<T> clz, Bundle args) {
         mActivity = activity;
         mTag = tag;
         mClass = clz;
         mArgs = args;

         // Check to see if we already have a fragment for this tab, probably
         // from a previously saved state. If so, deactivate it, because our
         // initial state is that a tab isn't shown.
         mFragment = mActivity.getSupportFragmentManager().findFragmentByTag(tag);
         if (mFragment != null && !mFragment.isDetached()) {
            FragmentTransaction ft = mActivity.getSupportFragmentManager().beginTransaction();
            ft.detach(mFragment);
            ft.commit();
         }
      }

      public void onTabSelected(Tab tab, FragmentTransaction ft)
      {
         if (mFragment == null) {
            mFragment = Fragment.instantiate(mActivity, mClass.getName(), mArgs);
            ft.add(android.R.id.content, mFragment, mTag);
         } else {
            ft.attach(mFragment);
         }
      }

      public void onTabUnselected(Tab tab, FragmentTransaction ft)
      {
         if (mFragment != null) {
            ft.detach(mFragment);
         }
      }

      public void onTabReselected(Tab tab, FragmentTransaction ft)
      {
         Toast.makeText(mActivity, "Reselected!", Toast.LENGTH_SHORT).show();
      }
   }

}
