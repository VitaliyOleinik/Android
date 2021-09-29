package com.raywenderlich.android.rwandroidtutorial.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.android.rwandroidtutorial.DependencyInjectorImpl
import com.raywenderlich.android.rwandroidtutorial.MainContract
import com.raywenderlich.android.rwandroidtutorial.R
import com.raywenderlich.android.rwandroidtutorial.data.counter.CounterModel
import com.raywenderlich.android.rwandroidtutorial.presenter.counter.CounterContract
import com.raywenderlich.android.rwandroidtutorial.presenter.counter.CounterPresenter

class CounterActivity : AppCompatActivity(), CounterContract.View {
    internal lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        setPresenter(CounterPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()
    }

    override fun displayCounterState(counterModel: CounterModel) {
        TODO("Not yet implemented")
    }

    override fun setPresenter(presenter: CounterContract.Presenter) {
        this.presenter = presenter
    }
}