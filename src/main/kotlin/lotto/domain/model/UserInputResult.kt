package lotto.domain.model

sealed interface UserInputResult<T> {
    data class Success<T>(val value: T) : UserInputResult<T>
    object Failed : UserInputResult<Nothing>
}
