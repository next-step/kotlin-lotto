package lotto.view

import lotto.domain.LottoReward
import lotto.domain.LottoRewards
import lotto.domain.LottoUsedTickets

object OutputView {

    fun displayTickets(manualTickets: LottoUsedTickets, autoTickets: LottoUsedTickets) {
        println("수동으로 ${manualTickets.getSize()}장, 자동으로 ${autoTickets.getSize()}개를 구매했습니다.")
        println((manualTickets + autoTickets).toString())
    }

    fun displayRewards(rewards: LottoRewards) {
        println("당첨 통계")
        val grouped = rewards.getByGroup()
        println(
            """
            3개 일치 (5000원)- ${grouped[LottoReward.FIFTH] ?: 0}개
            4개 일치 (50000원)- ${grouped[LottoReward.FIRTH] ?: 0}개
            5개 일치 (1500000원)- ${grouped[LottoReward.THIRD] ?: 0}개
            5개 일치, 보너스 볼 일치(30000000원) - ${grouped[LottoReward.SECOND] ?: 0}개
            6개 일치 (2000000000원)- ${grouped[LottoReward.FIRST] ?: 0}개
            """.trimIndent()
        )
    }

    fun displayProfitRate(profitRate: Long) {
        println("총 수익률은 ${profitRate}입니다. (기준: 1)")
    }
}
