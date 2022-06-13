package lotto.domain.model

sealed interface UserInputResult<out T> {
    data class Success<out T>(val value: T) : UserInputResult<T>
    object Failed : UserInputResult<Nothing>
}

fun <T> UserInputResult<T>.value(): T {
    return (this as UserInputResult.Success).value
}
