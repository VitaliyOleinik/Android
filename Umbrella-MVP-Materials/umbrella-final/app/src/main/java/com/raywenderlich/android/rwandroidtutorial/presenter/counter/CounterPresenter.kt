package com.raywenderlich.android.rwandroidtutorial.presenter.counter

import com.raywenderlich.android.rwandroidtutorial.DependencyInjector
import com.raywenderlich.android.rwandroidtutorial.data.counter.CounterModel
import com.raywenderlich.android.rwandroidtutorial.data.counter.CounterRepository

class CounterPresenter(view: CounterContract.View, di: DependencyInjector) : CounterContract.Presenter {

    private val counterRepository:CounterRepository = di.counterRepository()
    private var view:CounterContract.View? = view
    private var counterModel:CounterModel? = null

    override fun onViewCreated() {
        loadCounter()
    }

    override fun onIncrementWeatherTapped() {
        counterModel?.counter?.plus(1)
        view?.displayCounterState(counterModel!!)
    }

    override fun onDestroy() {
        this.view = null
    }

    override fun onLoadWeatherTapped() {
        TODO("Not yet implemented")
    }

    fun loadCounter(){
        counterModel = counterRepository.loadCounter()
        view?.displayCounterState(counterModel!!)
        counterRepository.loadCounter()
    }

}