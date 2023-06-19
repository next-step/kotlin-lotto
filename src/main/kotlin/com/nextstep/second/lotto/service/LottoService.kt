package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoPurchase
import com.nextstep.second.lotto.domain.LottoPurchase.Companion.of
import com.nextstep.second.lotto.domain.LottoResult
import com.nextstep.second.lotto.domain.WinnerLotto

object LottoService {
    fun buyLotto(lottoPurchase: LottoPurchase, numbersInManual: List<List<Int>>): List<Lotto> {
        val lottoInManual = buyLottoInManual(numbersInManual)
        val lottoInAuto = buyLottoInAuto(lottoPurchase.autoLottoCount)
        return lottoInManual + lottoInAuto
    }

    fun buyLottoInManual(manualLottos: List<List<Int>>): List<Lotto> {
        return manualLottos.map { numbers ->
            Lotto.of(numbers)
        }
    }

    fun buyLottoInAuto(cnt: Int): List<Lotto> {
        return (1..cnt).map { Lotto.of(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>, bonusNumber: Int): WinnerLotto {
        return WinnerLotto.of(numbers, bonusNumber)
    }

    fun checkThisWeekLottoResult(winnerLotto: WinnerLotto, myLottos: List<Lotto>): LottoResult {
        return LottoResult.of(winnerLotto, myLottos)
    }
}
