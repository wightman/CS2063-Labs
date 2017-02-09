package mobiledev.unb.ca.skeleton_lab4_part2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import mobiledev.unb.ca.skeleton_lab4_part2.dummy.DummyContent;

import java.util.List;

/**
 * An activity representing a list of Courses. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link CourseDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
public class CourseListActivity extends AppCompatActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    /** TODO 1:
     *
     * Create a DataModel member and List of Course member
     *
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        /** TODO 2:
         *
         * Create a new DataModel instance and get its list of courses. Store these in
         * the members created above. Notice the DataModel constructor requires a Context.
         * Remember each Activity has its own Context within an Android application.
         *
         */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        View recyclerView = findViewById(R.id.course_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.course_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;
        }
    }


    /** TODO 3:
     *
     * Notice that the RecyclerView is being passed an Adapter based on DummyContent.
     * Because we are operating with Course items, we must instead pass the collection
     * of Course items we obtained from our DataModel above to this Adapter.
     * Do that here.
     *
     */
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        /** TODO 4:
         *
         * Again, DummyContent values are being worked with here. Alter mValues
         * to instead store a local copy of our Course data that we captured from
         * our DataModel above.
         *
         */
        private final List<DummyContent.DummyItem> mValues;


        /** TODO 5:
         *
         * Again, replace the instance of DummyContent with our Course items.
         *
         */
        public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.course_list_content, parent, false);
            return new ViewHolder(view);
        }

        /** TODO 7:
         *
         * Notice how mContentView is attempting to be set with mValues.get(position).content
         * However, our Course items do not contain a content field. Given that this
         * onBindViewHolder is setting up our scrolling RecyclerView display we must consider
         * what information we wish that display to have. As described, we want to display
         * the Course ID and course name. Replace .content with the course name.
         *
         */
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).id);
            holder.mContentView.setText(mValues.get(position).content);

            /** TODO 8:
             *
             * This onClick behavior will describe what should happen when a particular
             * course is selected from our scrolling RecyclerView list. Based on the
             * position in the scrolling list, an ARG_ITEM_ID will be passed to the
             * CourseDetailFragment along with the data we wish to display within the
             * Detail fragment portion of our application.
             *
             * The Master/Detail Flow template provides the necessary behavior
             * performance specific to the particular device type the application is
             * running on, we must only ensure we pass the appropriate information. This
             * is demonstrated in the if/else check; if mTwoPane is true we're running
             * on a tablet and we simply wish to pass a Bundle of arguments to the fragment.
             * Otherwise, we are running on a phone and must instead create an Intent, and pass
             * the appropriate arguments to that intent.
             *
             * For us, when an item is clicked we wish to display the description of
             * that particular Course item. Currently the argument being placed in
             * the Bundle is the mItem.id DummyContent Item id.
             *
             * Replace each mItem.id below so that a description of the Course item instance,
             * created below in TODO 6, is sent instead.
             *
             */
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mTwoPane) {
                        Bundle arguments = new Bundle();
                        arguments.putString(CourseDetailFragment.ARG_ITEM_ID, holder.mItem.id);
                        CourseDetailFragment fragment = new CourseDetailFragment();
                        fragment.setArguments(arguments);
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.course_detail_container, fragment)
                                .commit();
                    } else {
                        Context context = v.getContext();
                        Intent intent = new Intent(context, CourseDetailActivity.class);
                        intent.putExtra(CourseDetailFragment.ARG_ITEM_ID, holder.mItem.id);

                        context.startActivity(intent);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        /** TODO 6:
         *
         * Replace the instance of a public DummyContent item with an instance of
         * a Course instead.
         *
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public DummyContent.DummyItem mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }
}
