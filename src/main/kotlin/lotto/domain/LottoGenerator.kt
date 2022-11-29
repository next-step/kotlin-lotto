package lotto.domain

import lotto.domain.LottoNumbers.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH

object LottoGenerator {
    private val lottoNumbers = (LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER).map { LottoNumber(it) }

    fun generate(): LottoNumbers {
        return LottoNumbers(lottoNumbers.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
