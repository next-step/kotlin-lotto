package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResultVo

const val LOTTO_COST = 1000
object LottoVendingMachine {
    fun buyLottoInRandom(money: Int): List<Lotto> {
        val cnt = money / LOTTO_COST
        return (1..cnt).map { Lotto(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>): Lotto {
        return Lotto(numbers)
    }

    fun checkThisWeekLottoResult(winnerLotto: Lotto, myLottos: List<Lotto>): LottoResultVo {
        return LottoResultVo(winnerLotto, myLottos)
    }
}
