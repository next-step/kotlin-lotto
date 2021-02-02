package com.nextstep.lotto.domain

class WinningLotto(lottoNumbers: List<LottoNumber>) : Lotto(lottoNumbers) {
    fun findNumberOfMatch(lotto: UserLotto): Int {
        return lotto.lottoNumbers.count { lottoNumbers.contains(it) }
    }

    companion object {
        fun generate(lottoNumbers: List<Int>): WinningLotto {
            return WinningLotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
        }
    }
}
