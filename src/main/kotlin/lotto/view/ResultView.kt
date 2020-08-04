package lotto.view

import lotto.domain.Customer
import lotto.domain.Lotto
import lotto.domain.value.WinLotto
import java.math.BigDecimal

object ResultView {
    private const val BUY_COUNT_SURFIX = "개를 구매했습니다."

    fun printBuyCount(customer: Customer) {
        println("${customer.count}$BUY_COUNT_SURFIX")
    }

    fun printLottos(lottos: List<Lotto>) {
        printJoinToString(lottos)
    }

    fun printResult(
        win: List<WinLotto>
    ) {
        println("당첨 통계")
        println("---------")
        printJoinToString(win)
    }

    fun printTotalRate(totalRate: BigDecimal) {
        println("총 수익률은 ${totalRate}입니다.")
    }

    private fun printJoinToString(lottos: List<Any>) {
        println(lottos.joinToString(""))
    }
}
