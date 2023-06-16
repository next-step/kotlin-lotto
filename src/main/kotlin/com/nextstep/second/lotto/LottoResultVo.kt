package com.nextstep.second.lotto

class LottoResultVo private constructor(
    winnerLottoNumber: Lotto,
    lottoNumber: Lotto
) {
    val sameNumberCount: Int

    init {
        sameNumberCount = winnerLottoNumber.numbers.intersect(lottoNumber.numbers.toSet()).size
    }

    companion object {
        fun of(winnerLotto: Lotto, lottoNumber: Lotto): LottoResultVo {
            return LottoResultVo(winnerLotto, lottoNumber)
        }
    }
}
