package com.nextstep.second.lotto.service

import com.nextstep.second.lotto.NumberGenerator
import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResultVo
import com.nextstep.second.lotto.domain.LottoReward

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
            LottoResultVo(winnerLotto, it)
        }
    }

    fun filterForDashBoard(lottoResults: List<LottoResultVo>): List<Map<LottoReward, Int>> {
        val filteredResult = lottoResults.groupBy { it.sameNumberCount }
            .mapValues { it.value.size }
            .entries
            .filter { it.key >= 3 }
            .sortedBy { it.key }

        return filteredResult.map { it ->
            mapOf(LottoReward.of(it.key) to it.value)
        }
    }
}
