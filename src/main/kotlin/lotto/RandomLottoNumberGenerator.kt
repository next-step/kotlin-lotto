package lotto

import lotto.LottoPolicy.LOTTO_NUMBER_COUNT
import lotto.LottoPolicy.MAX_LOTTO_NUMBER
import lotto.LottoPolicy.MIN_LOTTO_NUMBER

object RandomLottoNumberGenerator {
    private val lottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()

    fun generate(): List<Int> {
        return lottoNumbers.shuffled().take(LOTTO_NUMBER_COUNT)
    }
}