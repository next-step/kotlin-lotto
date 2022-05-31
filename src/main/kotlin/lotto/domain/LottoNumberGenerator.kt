package lotto.domain

import lotto.domain.dto.LottoNumber

class LottoNumberGenerator {
    companion object {
        fun autoGenerate(): LottoNumber = LottoNumber(LOTTO_NUMBER_RANGE.shuffled().slice(LOTTO_NUMBER_COUNT))

        private val LOTTO_NUMBER_COUNT = (0..5)
        private val LOTTO_NUMBER_RANGE = (1..45)
    }
}
