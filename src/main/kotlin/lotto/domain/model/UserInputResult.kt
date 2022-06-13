package lotto.domain.model

sealed interface UserInputResult<out T> {
    data class Success<out T>(val value: T) : UserInputResult<T>
    object Failed : UserInputResult<Nothing>
}

val <T> UserInputResult<T>.value: T
    get() = (this as UserInputResult.Success).value
