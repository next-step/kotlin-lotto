package com.nextstep.lotto.domain

open class Lotto(val lottoNumbers: List<LottoNumber>) {
    init {
        validate(lottoNumbers)
    }

    private fun validate(lottoNumbers: List<LottoNumber>) {
        require(lottoNumbers.size == NUMBER_OF_LOTTO_NUMBER) {
            "로또는 6개의 숫자로 이루어져 있습니다."
        }
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBER = 6
    }
}
