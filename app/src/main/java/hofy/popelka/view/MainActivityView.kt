package hofy.popelka.view

import com.hannesdorfmann.mosby3.mvp.MvpView
import hofy.popelka.domain.MainActivityViewState
import io.reactivex.Observable

interface MainActivityView : MvpView {
    fun displayText() : Observable<Unit>
    fun render(state : MainActivityViewState)
}