package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumber.Companion.MAX_VALUE
import lotto.model.LottoNumber.Companion.MIN_VALUE
import lotto.model.LottoNumbers
import lotto.model.LottoNumbers.Companion.NUMBER_OF_LOTTO_DIGIT

class LottoGenerator {

    fun generate(): LottoNumbers =
        LOTTO_NUMBER_STORAGE.shuffled()
            .take(NUMBER_OF_LOTTO_DIGIT)
            .sortedBy { it.value }
            .let(::LottoNumbers)

    companion object {
        private val LOTTO_NUMBER_STORAGE = (MIN_VALUE..MAX_VALUE).map(::LottoNumber)
    }
}
