package com.u.teach.contract;

/**
 * Created by saguilera on 1/21/17.
 */
public interface ContractPresenter<T extends ContractView> {

    void onAttach(T view);
    void onDetach();

}
