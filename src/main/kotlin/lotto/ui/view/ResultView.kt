package lotto.ui.view

import lotto.domain.LottoResult
import lotto.domain.LottoReward

object ResultView {
    fun printLottoResult(lottoResult: LottoResult) {
        val lottoWinningAmount = lottoResult.lottoWinningAmount
        println(
            "당첨 결과\n" +
                "---------\n" +
                "3개 일치 (5000원)- ${lottoWinningAmount.amountOf(LottoReward.MATCH_THREE.matchCount)}개\n" +
                "4개 일치 (50000원)- ${lottoWinningAmount.amountOf(LottoReward.MATCH_FOUR.matchCount)}개\n" +
                "5개 일치 (1500000원)- ${lottoWinningAmount.amountOf(LottoReward.MATCH_FIVE.matchCount)}개\n" +
                "6개 일치 (2000000000원)- ${lottoWinningAmount.amountOf(LottoReward.MATCH_SIX.matchCount)}개\n" +
                "총 수익률은 ${lottoResult.calculateReturnRate()}입니다."
        )
    }
}
