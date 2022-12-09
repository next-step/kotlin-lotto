package lotto.view

import lotto.model.Lotto
import lotto.model.LottoPrize
import lotto.model.Lottos
import lotto.model.WinningNumbers
import lotto.service.LottoShop
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.Comparator.comparingInt

object OutputView {
    fun printDetails(lottos: Lottos) {
        println("${lottos.size}개를 구매했습니다.")
        printLottos(lottos)
        println()
    }

    private fun printLottos(lottos: Lottos) {
        lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        val numberValueList = lotto.sortedWith(comparingInt { it.value }).map { it.value }
        println(numberValueList)
    }

    fun printResult(lottos: Lottos, winningNumbers: WinningNumbers) {
        println()
        println("당첨 통계")
        println("---------")

        val lottoPrizes = lottos.matchCounts(winningNumbers).map { LottoPrize.of(it) }

        printPrizeCount(lottoPrizes, LottoPrize.FOURTH)
        printPrizeCount(lottoPrizes, LottoPrize.THIRD)
        printPrizeCount(lottoPrizes, LottoPrize.SECOND)
        printPrizeCount(lottoPrizes, LottoPrize.FIRST)

        val totalPrize = lottoPrizes.map { it.prize }.reduce(BigDecimal::add)
        val returnRatio = returnRatioOf(lottos.size, totalPrize)

        println("총 수익률은 ${returnRatio}입니다.")
    }

    private fun printPrizeCount(lottoPrizes: List<LottoPrize>, target: LottoPrize) {
        val count = lottoPrizes.count { it == target }
        println("${target.matchCount}개 일치 (${target.prize}원) - ${count}개")
    }

    fun returnRatioOf(lottoCount: Int, winningPrize: BigDecimal): BigDecimal {
        val buyPrice = BigDecimal(lottoCount).multiply(LottoShop.LOTTO_PRICE)
        return winningPrize.divide(buyPrice, 2, RoundingMode.HALF_DOWN)
    }
}
