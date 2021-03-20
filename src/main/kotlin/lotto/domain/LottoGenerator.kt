package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT

object LottoGenerator {
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45

    fun generateLotto(): Lotto {
        val lottoNumbers = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled()
            .subList(0, LOTTO_NUMBER_COUNT)
            .map { LottoNumber.from(it) }

        return Lotto(lottoNumbers)
    }
}
