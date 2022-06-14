package lotto.domain.model

import lotto.view.inputconverter.InputConverter

data class UserInputRequest<T>(
    val message: String,
    val inputConverter: InputConverter<T>,
    val retryMessage: String = ""
)
