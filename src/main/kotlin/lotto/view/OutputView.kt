package lotto.view

import lotto.domain.LottoResult
import lotto.domain.Reward

class OutputView {
    fun printResult(lottoResult: LottoResult) {
        println(
            """
            당첨 통계
            ---------
            """.trimIndent()
        )
        lottoResult.winningRewards
            .forEach { (reward, count) ->
                when (reward) {
                    Reward.SECOND -> println("${reward.matchingNumberCount}개 일치, 보너스볼 일치(${reward.money}원)- ${count}개")
                    else -> println("${reward.matchingNumberCount}개 일치 (${reward.money}원)- ${count}개")
                }
            }
        println("총 수익률은 ${lottoResult.calculateRateOfReturn()}입니다.")
    }
}