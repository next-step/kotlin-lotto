package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoPurchase.Companion.PRICE
import com.nextstep.second.lotto.domain.LottoResult
import com.nextstep.second.lotto.domain.WinnerLotto

object LottoService {
    fun buyLottoInRandom(money: Int): List<Lotto> {
        val cnt = money / PRICE
        return (1..cnt).map { Lotto.of(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>, bonusNumber: Int): WinnerLotto {
        return WinnerLotto.of(numbers, bonusNumber)
    }

    fun checkThisWeekLottoResult(winnerLotto: WinnerLotto, myLottos: List<Lotto>): LottoResult {
        return LottoResult.of(winnerLotto, myLottos)
    }
}
