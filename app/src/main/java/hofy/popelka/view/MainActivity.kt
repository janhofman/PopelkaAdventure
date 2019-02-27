package hofy.popelka.view

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.clicks
import hofy.popelka.R
import hofy.popelka.domain.MainActivityViewState
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MviActivity<MainActivityView,MainActivityPresenter>(), MainActivityView {
    override fun displayText() = btn.clicks()

    override fun render(state: MainActivityViewState) {
        when(state){
            is MainActivityViewState.DataState -> text.text = state.text
        }
    }

    override fun createPresenter() = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
