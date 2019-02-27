package hofy.popelka.view

import android.util.Log
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import hofy.popelka.domain.GetTextUseCase
import hofy.popelka.domain.MainActivityViewState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivityPresenter : MviBasePresenter<MainActivityView, MainActivityViewState>() {
    override fun bindIntents() {
        val mainActivityViewState : Observable<MainActivityViewState> = intent(MainActivityView::displayText)
            .subscribeOn(Schedulers.io())
//            .debounce(400, TimeUnit.MILLISECONDS)
            .switchMap { GetTextUseCase.getText() }
            .doOnNext { Log.d("appTag", "Received new state: $it") }
            .observeOn(AndroidSchedulers.mainThread())
        subscribeViewState(mainActivityViewState, MainActivityView::render)
    }
}