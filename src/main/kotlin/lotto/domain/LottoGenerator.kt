package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumbers.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH

object LottoGenerator {
    private val lottoNumbers = List(MAXIMUM_LOTTO_NUMBER) { LottoNumber(it + MINIMUM_LOTTO_NUMBER) }

    fun generate(): LottoNumbers {
        return LottoNumbers(lottoNumbers.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
