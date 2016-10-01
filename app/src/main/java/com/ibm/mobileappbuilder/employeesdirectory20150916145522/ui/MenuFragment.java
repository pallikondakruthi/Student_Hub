

package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;

import android.os.Bundle;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;

import java.util.ArrayList;
import java.util.List;

import ibmmobileappbuilder.MenuItem;

import ibmmobileappbuilder.actions.StartActivityAction;
import ibmmobileappbuilder.util.Constants;

/**
 * MenuFragment menu fragment.
 */
public class MenuFragment extends ibmmobileappbuilder.ui.MenuFragment {

    /**
     * Default constructor
     */
    public MenuFragment(){
        super();
    }

    // Factory method
    public static MenuFragment newInstance(Bundle args) {
        MenuFragment fragment = new MenuFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
      public void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
                }

    // Menu Fragment interface
    @Override
    public List<MenuItem> getMenuItems() {
        ArrayList<MenuItem> items = new ArrayList<MenuItem>();
        items.add(new MenuItem()
            .setLabel("Students")
            .setIcon(R.drawable.png_studentidentitybadge512337)
            .setAction(new StartActivityAction(StudentsMenuItem1Activity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Status/ Attendance")
            .setIcon(R.drawable.png_featuresiconssurvey541)
            .setAction(new StartActivityAction(StatusActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Updates")
            .setIcon(R.drawable.png_newsicon413)
            .setAction(new StartActivityAction(NewsActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("Send SMS")
            .setIcon(R.drawable.png_peopleicon478)
            .setAction(new StartActivityAction(SendSMSActivity.class, Constants.DETAIL))
        );
        items.add(new MenuItem()
            .setLabel("CONTACT")
            .setIcon(R.drawable.jpg_14839908callcenterflatecogreencolorroundedvectoricon45)
            .setAction(new StartActivityAction(ContactInformationActivity.class, Constants.DETAIL))
        );
        return items;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_grid;
    }

    @Override
    public int getItemLayout() {
        return R.layout.menu_item;
    }
}

