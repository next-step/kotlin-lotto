package com.nextstep.second.lotto

const val LOTTO_COST = 1000

object LottoVendingMachine {
    fun buyLottoInRandom(money: Int): List<Lotto> {
        val cnt = money / LOTTO_COST
        return (1..cnt).map { Lotto(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>): Lotto {
        return Lotto(numbers)
    }

    fun checkThisWeekLottoResult(winnerLotto: Lotto, myLotto: List<Lotto>): List<LottoResultVo> {
        return myLotto.map {
            LottoResultVo.of(winnerLotto, it)
        }.toList()
    }
}
