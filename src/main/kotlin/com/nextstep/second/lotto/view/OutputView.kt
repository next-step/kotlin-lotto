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

    fun showLottoResult(lottoResults: List<Map<LottoReward, Int>>) {
        println("당첨 통계")
        println("---------")
        lottoResults.forEach { it ->
            println("${it.entries.first().key.sameNumberCnt}개 일치 (${it.entries.first().key.reward}원)- ${it.entries.first().value}개")
        }
    }
}
