package lotto.ui

import lotto.domain.LotteryTicket
import lotto.domain.PrizeStatics
import java.math.BigDecimal

object OutputView {
    fun showLotteryTicket(lotteryTicket: LotteryTicket) {
        println("${lotteryTicket.size}개를 구매했습니다.")
        lotteryTicket.forEach(::println)
    }

    fun showStatics(statics: PrizeStatics) {
        println("당첨 통계")
        println("---------")
        statics.forEach { prize, cnt ->
            println("${prize.matchCount}개 일치 (${prize.prizeMoney.value}원) - ${cnt}개")
        }
    }

    fun showProfitRate(profitRate: BigDecimal) {
        println("총 수익률은 ${profitRate}입니다.")
    }
}
