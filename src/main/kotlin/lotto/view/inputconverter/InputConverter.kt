package lotto.view.inputconverter

import lotto.domain.model.UserInputResult

interface InputConverter<T> {
    fun convert(input: String?): UserInputResult<T>
}
