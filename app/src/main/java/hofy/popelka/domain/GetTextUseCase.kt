package hofy.popelka.domain

import hofy.popelka.model.TextRepository
import io.reactivex.Observable

object GetTextUseCase {
    fun getText(): Observable<MainActivityViewState> {
        return TextRepository.loadText().map<MainActivityViewState> { MainActivityViewState.DataState(it) }
            .startWith(MainActivityViewState.LoadingState)
            .onErrorReturn { MainActivityViewState.ErrorState(it) }
    }
}