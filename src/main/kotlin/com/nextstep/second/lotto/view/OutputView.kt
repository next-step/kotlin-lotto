package com.nextstep.second.lotto.view

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoReward

object OutputView {
    fun showBuyLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }

    fun showLottoResult(lottoResults: Map<LottoReward, Int>) {
        println("당첨 통계")
        println("---------")
        val sortedMap = lottoResults.toSortedMap(compareBy { it.sameNumberCnt })
        sortedMap.forEach { it ->
            println("${it.key.sameNumberCnt}개 일치 (${it.key.reward}원)- ${it.value}개")
        }
    }
}
