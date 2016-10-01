
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;
import ibmmobileappbuilder.ds.Datasource;
import android.widget.TextView;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.MapsAction;
import ibmmobileappbuilder.actions.PhoneAction;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.Item;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.EmptyDatasource;

public class ContactInformationFragment extends ibmmobileappbuilder.ui.DetailFragment<Item>  {

    private Datasource<Item> datasource;
    private SearchOptions searchOptions;

    public static ContactInformationFragment newInstance(Bundle args){
        ContactInformationFragment card = new ContactInformationFragment();
        card.setArguments(args);

        return card;
    }

    public ContactInformationFragment(){
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            searchOptions = SearchOptions.Builder.searchOptions().build();
    }

    @Override
    public Datasource getDatasource() {
      if (datasource != null) {
          return datasource;
      }
          datasource = EmptyDatasource.getInstance(searchOptions);
          return datasource;
    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.contactinformation_custom;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final Item item, View view) {
        
        TextView view0 = (TextView) view.findViewById(R.id.view0);
        view0.setText("St.Martin's Engineering college");
        bindAction(view0, new MapsAction(
        new ActivityIntentLauncher()
        , "http://maps.google.com/maps?q=" + "St.Martin's Engineering college, Dhulapalli, Secunderabad - 500 014"));
        
        TextView view1 = (TextView) view.findViewById(R.id.view1);
        view1.setText("(555) 704-3829");
        bindAction(view1, new PhoneAction(
        new ActivityIntentLauncher()
        , "(555) 704-3829"));
        
        TextView view2 = (TextView) view.findViewById(R.id.view2);
        view2.setText("company@company.com");
        
    }

    @Override
    protected void onShow(Item item) {
        // set the title for this fragment
        getActivity().setTitle("Contact Information");
    }

}

