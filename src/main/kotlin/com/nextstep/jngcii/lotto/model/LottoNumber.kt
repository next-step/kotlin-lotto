package com.nextstep.jngcii.lotto.model

open class LottoNumber(val value: Int) {
    init {
        require(value in MINIMAL_NUMBER..MAXIMAL_NUMBER) {
            "$MINIMAL_NUMBER~${MAXIMAL_NUMBER}에 해당하는 숫자로 이루어진 숫자가 아닙니다."
        }
    }

    companion object {
        private const val MINIMAL_NUMBER = 1
        private const val MAXIMAL_NUMBER = 45
    }
}
