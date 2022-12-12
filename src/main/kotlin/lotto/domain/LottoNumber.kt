package lotto.domain

import lotto.application.common.Number

data class LottoNumber(
    val number: Number
) {

    init {
        require(number.number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { "로또 번호는 ${LOTTO_MIN_NUMBER}와 $LOTTO_MAX_NUMBER 사이 값 이여야 합니다." }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}
