package com.nextstep.second.lotto.domain

class LottoResultVo(
    winnerLottoNumber: Lotto,
    lottoNumber: Lotto
) {
    val sameNumberCount: Int

    init {
        sameNumberCount = winnerLottoNumber.numbers.intersect(lottoNumber.numbers.toSet()).size
    }
}
