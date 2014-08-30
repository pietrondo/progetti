package me.pietrocapriata.pietrolettore;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;




/**
 * An activity representing a list of Blogposts. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link BlogpostDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link BlogpostListFragment} and the item details
 * (if present) is a {@link BlogpostDetailFragment}.
 * <p>
 * This activity also implements the required
 * {@link BlogpostListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class BlogpostListActivity extends Activity
        implements BlogpostListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blogpost_list);

        if (findViewById(R.id.blogpost_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((BlogpostListFragment) getFragmentManager()
                    .findFragmentById(R.id.blogpost_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link BlogpostListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(BlogpostDetailFragment.ARG_ITEM_ID, id);
            BlogpostDetailFragment fragment = new BlogpostDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.blogpost_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, BlogpostDetailActivity.class);
            detailIntent.putExtra(BlogpostDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
