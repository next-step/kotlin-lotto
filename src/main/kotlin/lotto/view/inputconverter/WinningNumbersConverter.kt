package lotto.view.inputconverter

import lotto.domain.model.LottoNumber

object WinningNumbersConverter : InputConverter<Set<LottoNumber>> {
    private const val DELIMITER = ", "

    override fun convert(input: String): Set<LottoNumber> {
        val numbers = input
            .split(DELIMITER)
            .map { stringNumber ->
                LottoNumber[stringNumber.toInt()]
            }.toSet()

        return numbers
    }
}
