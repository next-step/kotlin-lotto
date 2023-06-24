package lotto.domain.numberGenerator

import lotto.domain.LottoNumber

class RandomLottoNumberGenerator : LottoNumberGenerator {

    override fun generateNumbers(): List<LottoNumber> {
        return rangeNumber.shuffled().take(NUMBER_OF_LOTTO).map { LottoNumber(it) }.sortedBy { it.value }
    }
    companion object {
        private const val MAX_LOTTO_NUMBER = 45
        private const val NUMBER_OF_LOTTO = 6
        private val rangeNumber = (1..MAX_LOTTO_NUMBER).toList()
    }
}
