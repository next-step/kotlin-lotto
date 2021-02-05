package com.nextstep.lotto.domain

object LottoFactory {
    private const val LOTTO_PRICE = 1000
    fun buyLotto(money: Money): List<Lotto> {
        val numberOfLotto = money.price.div(LOTTO_PRICE)
        return (1..numberOfLotto).map { drawRandomLotto() }
    }

    fun drawRandomLotto(): Lotto {
        return Lotto(LottoNumbers.drawRandomNumbers().sortedBy { it.number })
    }

    fun drawManualLotto(lottoNumbers: List<Int>): Lotto {
        return Lotto(lottoNumbers.map { LottoNumbers.valueOf(it) })
    }

    fun drawWinningLotto(lottoNumbers: List<Int>, bonusNumber: Int): WinningLotto {
        return WinningLotto(drawManualLotto(lottoNumbers), LottoNumbers.valueOf(bonusNumber))
    }
}
