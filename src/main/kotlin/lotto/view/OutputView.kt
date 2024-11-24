package lotto.view

import lotto.LottoResult

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
                println("${reward.matchingNumberCount}개 일치 (${reward.money}원)- ${count}개")
            }
        println("총 수익률은 ${lottoResult.calculateRateOfReturn()}입니다.")
    }
}