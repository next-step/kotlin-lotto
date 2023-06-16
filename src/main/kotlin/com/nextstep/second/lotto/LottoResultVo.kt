package com.nextstep.second.lotto

class LottoResultVo(
    winnerLottoNumber: Lotto,
    lottoNumber: Lotto
) {
    val sameNumberCount: Int

    init {
        sameNumberCount = winnerLottoNumber.numbers.intersect(lottoNumber.numbers.toSet()).size
    }
}
