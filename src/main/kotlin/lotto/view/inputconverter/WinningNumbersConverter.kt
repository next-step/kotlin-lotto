package lotto.view.inputconverter

import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber

object WinningNumbersConverter : InputConverter<Lotto> {
    private const val DELIMITER = ", "

    override fun convert(input: String): Lotto {
        val numbers = input
            .split(DELIMITER)
            .map { stringNumber ->
                LottoNumber[stringNumber.toInt()]
            }.toSet()

        return Lotto(numbers)
    }
}
