package lotto

import lotto.LottoRule.LOTTO_NUMBER_COUNT
import lotto.LottoRule.MAX_NUMBER
import lotto.LottoRule.MIN_NUMBER

/**
 * 로또 번호 추출기
 */
object Extractor {

    val randomNumberFunc = {
        (MIN_NUMBER..MAX_NUMBER)
            .shuffled()
            .take(LOTTO_NUMBER_COUNT)
            .map { LottoNumber(it) }
    }
}
