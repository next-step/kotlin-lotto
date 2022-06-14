package lotto.domain.model

sealed interface UserInputResult<out T> {
    data class Success<out T>(val result: T) : UserInputResult<T>
    object Failed : UserInputResult<Nothing>
}

val <T> UserInputResult<T>.result: T
    get() = (this as UserInputResult.Success).result
