package lotto.entity

import lotto.util.MAX_LOTTO_NUMBER
import lotto.util.MIN_LOTTO_NUMBER

data class LottoNumber(val value: Int) {
    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)
        { "로또 번호는 $MIN_LOTTO_NUMBER~$MAX_LOTTO_NUMBER 사이여야 합니다." }
    }

    override fun toString(): String {
        return value.toString()
    }
}