package com.prabhakar.basis_assignment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.prabhakar.basis_assignment.remote.data.ResponseModel
import com.prabhakar.basis_assignment.repo.Repository
import com.prabhakar.basis_assignment.util.QuotesAppModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class QuotesViewModel() : ViewModel() {
    private val repository = Repository()
    private lateinit var disposable: Disposable
    private val mutableLiveData = MutableLiveData<QuotesAppModel>()
    var liveData: LiveData<QuotesAppModel> = mutableLiveData


//    Taking Data from Repository Class giving to subscribers views which view will subscribe this ViewModel class

    fun getAllQuotes() {
        return repository.getQuotesFromServer().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseModel> {
                override fun onSubscribe(d: Disposable?) {
                    d?.run {
                        disposable=d
                    }
                }

                override fun onNext(t: ResponseModel?) {
                   t?.run {
                       mutableLiveData.value=QuotesAppModel.OnSuccess(this)
                       liveData=mutableLiveData
                   }
                }

                override fun onError(e: Throwable?) {

                }

                override fun onComplete() {

                }

            })
    }
}