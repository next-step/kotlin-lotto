package lotto.domain.model

data class InputValidationChecker<T>(
    val retryMessage: String,
    val validate: (T) -> Boolean
)
