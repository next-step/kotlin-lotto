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
        throw IllegalArgumentException("You need to enter six numbers separated by comma as the delimiter.(ex - 1,2,3, 4, 5,6)")
    }
}
