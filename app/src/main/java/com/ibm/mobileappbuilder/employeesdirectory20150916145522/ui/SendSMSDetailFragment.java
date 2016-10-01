
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.ui;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;
import ibmmobileappbuilder.actions.ActivityIntentLauncher;
import ibmmobileappbuilder.actions.MailAction;
import ibmmobileappbuilder.behaviors.ShareBehavior;
import ibmmobileappbuilder.ds.restds.AppNowDatasource;
import ibmmobileappbuilder.util.image.ImageLoader;
import ibmmobileappbuilder.util.image.PicassoImageLoader;
import ibmmobileappbuilder.util.StringUtils;
import java.net.URL;
import static ibmmobileappbuilder.util.image.ImageLoaderRequest.Builder.imageLoaderRequest;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.ds.SearchOptions;
import ibmmobileappbuilder.ds.filter.Filter;
import java.util.Arrays;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.EmployeesDBDSItem;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.EmployeesDBDS;

public class SendSMSDetailFragment extends ibmmobileappbuilder.ui.DetailFragment<EmployeesDBDSItem> implements ShareBehavior.ShareListener  {

    private Datasource<EmployeesDBDSItem> datasource;
    public static SendSMSDetailFragment newInstance(Bundle args){
        SendSMSDetailFragment fr = new SendSMSDetailFragment();
        fr.setArguments(args);

        return fr;
    }

    public SendSMSDetailFragment(){
        super();
    }

    @Override
    public Datasource<EmployeesDBDSItem> getDatasource() {
      if (datasource != null) {
        return datasource;
      }
       datasource = EmployeesDBDS.getInstance(new SearchOptions());
        return datasource;
    }

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        addBehavior(new ShareBehavior(getActivity(), this));

    }

    // Bindings

    @Override
    protected int getLayout() {
        return R.layout.sendsmsdetail_detail;
    }

    @Override
    @SuppressLint("WrongViewCast")
    public void bindView(final EmployeesDBDSItem item, View view) {
        if (item.name != null){
            
            TextView view0 = (TextView) view.findViewById(R.id.view0);
            view0.setText(item.name);
            
        }
        if (item.lastname != null){
            
            TextView view1 = (TextView) view.findViewById(R.id.view1);
            view1.setText(item.lastname);
            
        }
        
        ImageView view2 = (ImageView) view.findViewById(R.id.view2);
        URL view2Media = ((AppNowDatasource) getDatasource()).getImageUrl(item.picture);
        if(view2Media != null){
          ImageLoader imageLoader = new PicassoImageLoader(view2.getContext());
          imageLoader.load(imageLoaderRequest()
                                   .withPath(view2Media.toExternalForm())
                                   .withTargetView(view2)
                                   .fit()
                                   .build()
                    );
        	
        } else {
          view2.setImageDrawable(null);
        }
        if (item.role != null){
            
            TextView view3 = (TextView) view.findViewById(R.id.view3);
            view3.setText(item.role);
            
        }
        if (item.email != null){
            
            TextView view4 = (TextView) view.findViewById(R.id.view4);
            view4.setText(item.email);
            
        }
        if (item.phone != null){
            
            TextView view5 = (TextView) view.findViewById(R.id.view5);
            view5.setText(item.phone);
            bindAction(view5, new MailAction(
            new ActivityIntentLauncher()
            , item.phone));
        }
    }

    @Override
    protected void onShow(EmployeesDBDSItem item) {
        // set the title for this fragment
        getActivity().setTitle(null);
    }
    @Override
    public void onShare() {
        EmployeesDBDSItem item = getItem();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, (item.name != null ? item.name : "" ) + "\n" +
                    (item.lastname != null ? item.lastname : "" ) + "\n" +
                    (item.role != null ? item.role : "" ) + "\n" +
                    (item.email != null ? item.email : "" ) + "\n" +
                    (item.phone != null ? item.phone : "" ));
        startActivityForResult(Intent.createChooser(intent, getString(R.string.share)), 1);
    }
}

