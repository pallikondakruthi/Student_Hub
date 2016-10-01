
package com.ibm.mobileappbuilder.employeesdirectory20150916145522.presenters;

import com.ibm.mobileappbuilder.employeesdirectory20150916145522.R;
import com.ibm.mobileappbuilder.employeesdirectory20150916145522.ds.EmployeesDBDSItem;

import java.util.List;

import ibmmobileappbuilder.ds.CrudDatasource;
import ibmmobileappbuilder.ds.Datasource;
import ibmmobileappbuilder.mvp.presenter.BasePresenter;
import ibmmobileappbuilder.mvp.presenter.ListCrudPresenter;
import ibmmobileappbuilder.mvp.view.CrudListView;

public class SendSMSPresenter extends BasePresenter implements ListCrudPresenter<EmployeesDBDSItem>,
      Datasource.Listener<EmployeesDBDSItem>{

    private final CrudDatasource<EmployeesDBDSItem> crudDatasource;
    private final CrudListView<EmployeesDBDSItem> view;

    public SendSMSPresenter(CrudDatasource<EmployeesDBDSItem> crudDatasource,
                                         CrudListView<EmployeesDBDSItem> view) {
       this.crudDatasource = crudDatasource;
       this.view = view;
    }

    @Override
    public void deleteItem(EmployeesDBDSItem item) {
        crudDatasource.deleteItem(item, this);
    }

    @Override
    public void deleteItems(List<EmployeesDBDSItem> items) {
        crudDatasource.deleteItems(items, this);
    }

    @Override
    public void addForm() {
        view.showAdd();
    }

    @Override
    public void editForm(EmployeesDBDSItem item, int position) {
        view.showEdit(item, position);
    }

    @Override
    public void detail(EmployeesDBDSItem item, int position) {
        view.showDetail(item, position);
    }

    @Override
    public void onSuccess(EmployeesDBDSItem item) {
                view.showMessage(R.string.items_deleted);
        view.refresh();
    }

    @Override
    public void onFailure(Exception e) {
        view.showMessage(R.string.error_data_generic);
    }

}

