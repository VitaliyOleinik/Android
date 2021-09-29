package com.raywenderlich.android.rwandroidtutorial.presenter.counter

import com.raywenderlich.android.rwandroidtutorial.BasePresenter
import com.raywenderlich.android.rwandroidtutorial.BaseView
import com.raywenderlich.android.rwandroidtutorial.MainContract
import com.raywenderlich.android.rwandroidtutorial.WeatherState
import com.raywenderlich.android.rwandroidtutorial.data.counter.CounterModel

interface CounterContract {
    interface Presenter : BasePresenter, MainContract.Presenter {
        override fun onViewCreated()
        fun onIncrementWeatherTapped()
    }

    interface View : BaseView<Presenter> {
        fun displayCounterState(counterModel: CounterModel)
    }
}