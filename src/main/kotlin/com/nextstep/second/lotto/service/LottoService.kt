package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResult

object LottoService {
    fun buyLottoInRandom(money: Int): List<Lotto> {
        val cnt = money / Lotto.PRICE
        return (1..cnt).map { Lotto.of(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>): Lotto {
        return Lotto.of(numbers)
    }

    fun checkThisWeekLottoResult(winnerLotto: Lotto, myLottos: List<Lotto>): LottoResult {
        return LottoResult.of(winnerLotto, myLottos)
    }
}
