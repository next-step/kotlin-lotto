package lotto.domain

import lotto.domain.LottoRule.LOTTO_NUMBER_COUNT
import lotto.domain.LottoRule.MAX_NUMBER
import lotto.domain.LottoRule.MIN_NUMBER

/**
 * 로또 번호 추출기
 */
object Extractor {

    private val LOTTO_NUMBERS = (MIN_NUMBER..MAX_NUMBER).map {
        LottoNumber(it)
    }

    val randomNumberFunc = {
        LOTTO_NUMBERS.shuffled().take(LOTTO_NUMBER_COUNT)
    }
}
