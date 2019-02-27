package hofy.popelka.domain

sealed class MainActivityViewState {
    object LoadingState : MainActivityViewState()
    data class DataState(val text : String) : MainActivityViewState()
    data class ErrorState(val error : Throwable) : MainActivityViewState()
}