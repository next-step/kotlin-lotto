package com.nextstep.lotto.domain

class WinningLotto(lottoNumbers: List<LottoNumber>) : Lotto(lottoNumbers) {
    fun findNumberOfMatch(lotto: UserLotto): Int {
        return lotto.lottoNumbers.filter { lottoNumbers.contains(it) }.count()
    }

    companion object {
        fun generate(lottoNumbers: List<Int>): WinningLotto {
            return WinningLotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
        }
    }
}
