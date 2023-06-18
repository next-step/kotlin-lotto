package com.nextstep.second.lotto.view

import com.nextstep.second.lotto.domain.Lotto
import com.nextstep.second.lotto.domain.LottoResult
import com.nextstep.second.lotto.domain.LottoReward

object OutputView {
    fun showBuyLotto(lottos: List<Lotto>) {
        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.numbers)
        }
    }

    fun showLottoResult(money: Int, lottoResults: LottoResult, checkRewards: List<LottoReward>) {
        println("당첨 통계")
        println("---------")
        checkRewards.forEach { reward ->
            println("${reward.totalSameNumber}개 일치 (${reward.reward}원)- ${lottoResults.getMatchedNumber(reward)}개")
        }
        println("총 수익률은 ${lottoResults.getRateOfReturn(money)}입니다.")
    }
}
