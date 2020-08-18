package com.nextstep.lotto.domain

class WinningLotto(private val lottoNumbers: List<LottoNumber>) {
    init {
        validate(lottoNumbers)
    }

    private fun validate(lottoNumbers: List<LottoNumber>) {
        if (lottoNumbers.size != NUMBER_OF_LOTTO_NUMBER) {
            throw IllegalArgumentException("로또는 6개의 숫자로 이루어져 있습니다.")
        }
    }

    fun findNumberOfMatch(lotto: Lotto): Int {
        return lotto.lottoNumbers.filter { lottoNumbers.contains(it) }.count()
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBER = 6
        fun generate(lottoNumbers: List<Int>): WinningLotto {
            return WinningLotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
        }
    }
}
