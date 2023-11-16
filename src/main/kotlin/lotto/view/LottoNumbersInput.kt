package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class LottoNumbersInput(text: String) {
    val numbers: LottoNumbers

    init {
        numbers = LottoNumbers(
            text.split(',').map { lottoNumberOrException(it) }
        )
    }

    private fun lottoNumberOrException(it: String) = try {
        LottoNumber(it.trim().toInt())
    } catch (e: Exception) {
        throw IllegalArgumentException("Word between commas is not a number!")
    }
}
