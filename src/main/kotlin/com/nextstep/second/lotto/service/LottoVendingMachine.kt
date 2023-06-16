package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResultVo
import com.nextstep.second.lotto.domain.LottoReward

const val LOTTO_COST = 1000
const val LOTTO_WINNER_SAME_NUMBER = 3
object LottoVendingMachine {
    fun buyLottoInRandom(money: Int): List<Lotto> {
        val cnt = money / LOTTO_COST
        return (1..cnt).map { Lotto(NumberGenerator.generate()) }
    }

    fun getWinnerLotto(numbers: List<Int>): Lotto {
        return Lotto(numbers)
    }

    fun checkThisWeekLottoResult(winnerLotto: Lotto, myLottos: List<Lotto>): List<LottoResultVo> {
        return myLottos.map { lotto ->
            LottoResultVo(winnerLotto, lotto)
        }
    }

    fun filterForDashBoard(lottoResults: List<LottoResultVo>): Map<LottoReward, Int> {
        return lottoResults.filter {
            it.sameNumberCount >= LOTTO_WINNER_SAME_NUMBER
        }.groupBy { it.sameNumberCount }
            .mapValues { it.value.size }
            .map { LottoReward.of(it.key) to it.value }
            .toMap()
    }
}
