package mobiledev.unb.ca.skeleton_lab4_part2;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mobiledev.unb.ca.skeleton_lab4_part2.dummy.DummyContent;

/**
 * A fragment representing a single Course detail screen.
 * This fragment is either contained in a {@link CourseListActivity}
 * in two-pane mode (on tablets) or a {@link CourseDetailActivity}
 * on handsets.
 */
public class CourseDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";


    /** TODO 9:
     *
     * Here, DummyContent is utilized to process an entire item. Because we'll only
     * ever be needing just the description of a course, we'll instead replace this
     * with just a String instance and later capture the particular course description String
     * we are interested in.
     *
     */
    private DummyContent.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CourseDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {

            /** TODO 10:
             *
             * Because we are not working directly with an instance of our collection, but
             * are rather interested in strictly obtaining the description String that was
             * passed to our CourseDetailFragment inside a Bundle, we can simply eliminate
             * the DummyContent.ITEM_MAP.get() and rather get our String argument directly
             * from the data passed to us in the Bundle.
             *
             */
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle("Courses");
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.course_detail, container, false);

        /** TODO 11:
         *
         * Again, because we are not accessing an entire Course item at once, but are instead
         * working with a single description String passed to our CourseDetailFragment inside
         * a Bundle, we do not need to attempt accessing specific portions of an item
         * as is being done here in the template using the DummyContent Item.
         *
         * Rather than mItem.details, we wish instead to simply set the TextView of this Fragment
         * to be the description String that was passed to us via Bundle.
         *
         */
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.course_detail)).setText(mItem.details);
        }

        return rootView;
    }
}
