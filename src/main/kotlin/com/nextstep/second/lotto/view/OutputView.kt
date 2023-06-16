package com.nextstep.second.lotto.view

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResultVo

object OutputView {
    fun showBuyLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }

    fun showLottoResult(lottoResults: List<LottoResultVo>) {
        println("당첨 통계")
        println("---------")
        val dashboardResult = lottoResults.groupBy { it.sameNumberCount }
            .mapValues { it.value.size }
            .entries
            .filter { it.key >= 3 }
            .sortedBy { it.key }
        dashboardResult.forEach {
            println("${it.key} - ${it.value}")
        }
    }
}
