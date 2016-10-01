

package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Arrays;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;

import ibmmobileappbuilder.ui.BaseFragment;
import ibmmobileappbuilder.ui.FilterActivity;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.EmployeesDBDS;
import ibmmobileappbuilder.dialogs.ValuesSelectionDialog;
import ibmmobileappbuilder.views.ListSelectionPicker;
import java.util.ArrayList;

/**
 * StudentsMenuItem1FilterActivity filter activity
 */
public class StudentsMenuItem1FilterActivity extends FilterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // set title
        setTitle(R.string.studentsMenuItem1FilterActivity);
    }

    @Override
    protected Fragment getFragment() {
        return new PlaceholderFragment();
    }

    public static class PlaceholderFragment extends BaseFragment {
        private SearchOptions.Builder searchOptionsBuilder = SearchOptions.Builder.searchOptions();
        private SearchOptions searchOptions;

        // filter field values
            
    ArrayList<String> name_values;
    
    ArrayList<String> lastname_values;
    
    ArrayList<String> role_values;
    
    ArrayList<String> email_values;
    
    ArrayList<String> phone_values;

        public PlaceholderFragment() {
              searchOptions = SearchOptions.Builder.searchOptions().build();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            return inflater.inflate(R.layout.studentsmenuitem1_filter, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            // Get saved values
            Bundle bundle = savedInstanceState;
            if(bundle == null) {
                bundle = getArguments();
            }
            // get initial data
                        
            name_values = bundle.getStringArrayList("name_values");
            
            lastname_values = bundle.getStringArrayList("lastname_values");
            
            role_values = bundle.getStringArrayList("role_values");
            
            email_values = bundle.getStringArrayList("email_values");
            
            phone_values = bundle.getStringArrayList("phone_values");

            // bind pickers
                        
            final ListSelectionPicker name_view = (ListSelectionPicker) view.findViewById(R.id.name_filter);
            ValuesSelectionDialog name_dialog = (ValuesSelectionDialog) getFragmentManager().findFragmentByTag("name");
            if (name_dialog == null)
                name_dialog = new ValuesSelectionDialog();
            
            // configure the dialog
            name_dialog.setColumnName("name")
                .setDatasource(EmployeesDBDS.getInstance(searchOptions))
                .setSearchOptions(searchOptions)
                .setTitle("Name")
                .setHaveSearch(true)
                .setMultipleChoice(true);
            
            // bind the dialog to the picker
            name_view.setSelectionDialog(name_dialog)
                .setTag("name")
                .setSelectedValues(name_values)
                .setSelectedListener(new ListSelectionPicker.ListSelectedListener() {
                @Override
                public void onSelected(ArrayList<String> selected) {
                    name_values = selected;
                }
            });
            
            final ListSelectionPicker lastname_view = (ListSelectionPicker) view.findViewById(R.id.lastname_filter);
            ValuesSelectionDialog lastname_dialog = (ValuesSelectionDialog) getFragmentManager().findFragmentByTag("lastname");
            if (lastname_dialog == null)
                lastname_dialog = new ValuesSelectionDialog();
            
            // configure the dialog
            lastname_dialog.setColumnName("lastname")
                .setDatasource(EmployeesDBDS.getInstance(searchOptions))
                .setSearchOptions(searchOptions)
                .setTitle("Lastname")
                .setHaveSearch(true)
                .setMultipleChoice(true);
            
            // bind the dialog to the picker
            lastname_view.setSelectionDialog(lastname_dialog)
                .setTag("lastname")
                .setSelectedValues(lastname_values)
                .setSelectedListener(new ListSelectionPicker.ListSelectedListener() {
                @Override
                public void onSelected(ArrayList<String> selected) {
                    lastname_values = selected;
                }
            });
            
            final ListSelectionPicker role_view = (ListSelectionPicker) view.findViewById(R.id.role_filter);
            ValuesSelectionDialog role_dialog = (ValuesSelectionDialog) getFragmentManager().findFragmentByTag("role");
            if (role_dialog == null)
                role_dialog = new ValuesSelectionDialog();
            
            // configure the dialog
            role_dialog.setColumnName("role")
                .setDatasource(EmployeesDBDS.getInstance(searchOptions))
                .setSearchOptions(searchOptions)
                .setTitle("Role")
                .setHaveSearch(true)
                .setMultipleChoice(true);
            
            // bind the dialog to the picker
            role_view.setSelectionDialog(role_dialog)
                .setTag("role")
                .setSelectedValues(role_values)
                .setSelectedListener(new ListSelectionPicker.ListSelectedListener() {
                @Override
                public void onSelected(ArrayList<String> selected) {
                    role_values = selected;
                }
            });
            
            final ListSelectionPicker email_view = (ListSelectionPicker) view.findViewById(R.id.email_filter);
            ValuesSelectionDialog email_dialog = (ValuesSelectionDialog) getFragmentManager().findFragmentByTag("email");
            if (email_dialog == null)
                email_dialog = new ValuesSelectionDialog();
            
            // configure the dialog
            email_dialog.setColumnName("email")
                .setDatasource(EmployeesDBDS.getInstance(searchOptions))
                .setSearchOptions(searchOptions)
                .setTitle("Email")
                .setHaveSearch(true)
                .setMultipleChoice(true);
            
            // bind the dialog to the picker
            email_view.setSelectionDialog(email_dialog)
                .setTag("email")
                .setSelectedValues(email_values)
                .setSelectedListener(new ListSelectionPicker.ListSelectedListener() {
                @Override
                public void onSelected(ArrayList<String> selected) {
                    email_values = selected;
                }
            });
            
            final ListSelectionPicker phone_view = (ListSelectionPicker) view.findViewById(R.id.phone_filter);
            ValuesSelectionDialog phone_dialog = (ValuesSelectionDialog) getFragmentManager().findFragmentByTag("phone");
            if (phone_dialog == null)
                phone_dialog = new ValuesSelectionDialog();
            
            // configure the dialog
            phone_dialog.setColumnName("phone")
                .setDatasource(EmployeesDBDS.getInstance(searchOptions))
                .setSearchOptions(searchOptions)
                .setTitle("Phone")
                .setHaveSearch(true)
                .setMultipleChoice(true);
            
            // bind the dialog to the picker
            phone_view.setSelectionDialog(phone_dialog)
                .setTag("phone")
                .setSelectedValues(phone_values)
                .setSelectedListener(new ListSelectionPicker.ListSelectedListener() {
                @Override
                public void onSelected(ArrayList<String> selected) {
                    phone_values = selected;
                }
            });

            // Bind buttons
            Button okBtn = (Button) view.findViewById(R.id.ok);
            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();

                    // send filter result back to caller
                                        
                    intent.putStringArrayListExtra("name_values", name_values);
                    
                    intent.putStringArrayListExtra("lastname_values", lastname_values);
                    
                    intent.putStringArrayListExtra("role_values", role_values);
                    
                    intent.putStringArrayListExtra("email_values", email_values);
                    
                    intent.putStringArrayListExtra("phone_values", phone_values);

                    getActivity().setResult(RESULT_OK, intent);
                    getActivity().finish();
                }
            });

            Button cancelBtn = (Button) view.findViewById(R.id.reset);
            cancelBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Reset values
                                        
                    name_values = new ArrayList<String>();
                    name_view.setSelectedValues(null);
                    
                    lastname_values = new ArrayList<String>();
                    lastname_view.setSelectedValues(null);
                    
                    role_values = new ArrayList<String>();
                    role_view.setSelectedValues(null);
                    
                    email_values = new ArrayList<String>();
                    email_view.setSelectedValues(null);
                    
                    phone_values = new ArrayList<String>();
                    phone_view.setSelectedValues(null);
                }
            });
        }

        @Override
        public void onSaveInstanceState(Bundle bundle) {
            super.onSaveInstanceState(bundle);

            // save current status
                        
            bundle.putStringArrayList("name_values", name_values);
            
            bundle.putStringArrayList("lastname_values", lastname_values);
            
            bundle.putStringArrayList("role_values", role_values);
            
            bundle.putStringArrayList("email_values", email_values);
            
            bundle.putStringArrayList("phone_values", phone_values);
        }
    }

}

