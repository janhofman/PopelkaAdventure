package hofy.popelka.model

import io.reactivex.Observable
import kotlin.random.Random

object TextRepository {

    fun loadText():Observable<String> = Observable.just(getText())

    fun getText():String{
        val messages = listOf("Hello World", "Hola Mundo", "Hallo Welt", "Bonjour le monde")
        return messages[Random.nextInt(messages.size)]
    }
}