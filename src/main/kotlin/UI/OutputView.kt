package UI

import domain.LottoInput
import domain.PurchasedLotto
import domain.Rank

object OutputView {

    fun ticketCountView(ticketCount: Int) {
        println("${ticketCount}개를 구매했습니다.")
    }

    fun purchaseLottoView(purchasedLottos: List<PurchasedLotto>) {
        purchasedLottos.forEach{
            println(it.numbers.joinToString { "," })
        }
    }

    fun statisticDividerView() {
        println("당첨 통계")
        println("---------")
    }

    fun statisticRateView(rate: Double) {
        print("총 수익률은 ${rate}입니다.")
        println("(기준이 1이기 때문에 결과적으로 ${if (rate >= 1) "이익" else "손해"}라는 의미임)")
    }

    fun statisticPrizeView(rank: Rank, winCount: Int) {
        println("${rank.matchedCount}개 일치 (${rank.prize}원) - ${winCount}개")
    }
}