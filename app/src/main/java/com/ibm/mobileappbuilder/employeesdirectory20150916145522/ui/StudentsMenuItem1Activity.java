

package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;

import ibmmobileappbuilder.ui.BaseListingActivity;
/**
 * StudentsMenuItem1Activity list activity
 */
public class StudentsMenuItem1Activity extends BaseListingActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.studentsMenuItem1Activity));
    }

    @Override
    protected Class<? extends Fragment> getFragmentClass() {
        return StudentsMenuItem1Fragment.class;
    }

}

