package com.nextstep.lotto.domain

object LottoFactory {
    private const val LOTTO_PRICE = 1000
    fun buyManualLotto(money: Money, manualLottoNumbers: List<List<Int>>): List<Lotto> {
        val numberOfManualLotto = manualLottoNumbers.size
        money.pay(numberOfManualLotto * LOTTO_PRICE)
        return manualLottoNumbers.map { drawManualLotto(it) }
    }

    fun buyAutoLotto(money: Money): List<Lotto> {
        val numberOfLotto = money.money.div(LOTTO_PRICE)
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

    fun checkBuy(money: Money, numberOfManualLotto: Int) {
        require(money.money >= (LOTTO_PRICE * numberOfManualLotto)) { "${numberOfManualLotto}개 구입할 수 없습니다." }
    }
}
