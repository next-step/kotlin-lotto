package lotto.view.inputconverter

import lotto.domain.model.LottoNumber
import lotto.domain.model.WinningNumbers

object WinningNumbersConverter : InputConverter<WinningNumbers> {
    private const val DELIMITER = ", "

    override fun convert(input: String): WinningNumbers {
        val numbers = input
            .split(DELIMITER)
            .map { stringNumber ->
                LottoNumber[stringNumber.toInt()]
            }.toSet()

        return WinningNumbers(numbers)
    }
}
