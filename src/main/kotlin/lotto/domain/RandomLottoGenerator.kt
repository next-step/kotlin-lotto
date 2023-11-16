package lotto.domain

import lotto.domain.LottoGenerator.Companion.MAX_LOTTO_NUMBER_COUNT

class RandomLottoGenerator : LottoGenerator {
    override fun generateLotto(): Lotto {
        val lottoNumbers = LottoNumbers.LOTTO_NUMBERS.shuffled().take(MAX_LOTTO_NUMBER_COUNT)
        return Lotto.fromLottoNumbers(lottoNumbers)
    }
}
