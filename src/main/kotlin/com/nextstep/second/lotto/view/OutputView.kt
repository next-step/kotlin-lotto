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
            println("${getComment(reward)} - ${lottoResults.getMatchedNumberCnts(reward)}개")
        }
        println("총 수익률은 ${lottoResults.getRateOfReturn(money)}입니다.")
    }

    private fun getComment(reward: LottoReward): String {
        return when (reward) {
            LottoReward.THIRD -> "${LottoReward.THIRD.totalSameNumber}개 일치 (${LottoReward.THIRD.reward}원)"
            LottoReward.FOURTH -> "${LottoReward.FOURTH.totalSameNumber}개 일치 (${LottoReward.FOURTH.reward}원)"
            LottoReward.FIFTH -> "${LottoReward.FIFTH.totalSameNumber}개 일치 (${LottoReward.FIFTH.reward}원)"
            LottoReward.FIFTH_BONUS -> "${LottoReward.FIFTH_BONUS.totalSameNumber}개 일치, 보너스볼 일치 (${LottoReward.FIFTH_BONUS.reward}원)"
            LottoReward.SIXTH -> "${LottoReward.SIXTH.totalSameNumber}개 일치 (${LottoReward.SIXTH.reward}원)"
            LottoReward.NONE -> "당첨 수령한 결과가 아님"
        }
    }
}
