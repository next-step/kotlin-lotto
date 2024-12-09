package lotto.domain

import lotto.domain.LottoConstants.MAX_LOTTO_NUMBER
import lotto.domain.LottoConstants.MIN_LOTTO_NUMBER

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

}
