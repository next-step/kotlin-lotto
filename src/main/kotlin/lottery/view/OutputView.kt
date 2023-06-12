package lottery.view

import lottery.domain.LottoResult
import lottery.domain.Rank

private const val LOTTERY_NUMBER_DELIMITER = ", "

fun printPurchaseLotteries(lotteries: List<List<Int>>) {
    println("${lotteries.size}를 구매했습니다.")
    lotteries.forEach { printLottery(it) }
}

fun printLottoResult(lottoResult: LottoResult) {
    println("당첨 통계")
    println("---------")
    lottoResult.statistics
        .forEach { printStatistic(it) }
    println("총 수익률은 ${lottoResult.yield}입니다.")
}

private fun printStatistic(it: Map.Entry<Rank, Int>) {
    println("${it.key.equalCount}개 일치 (${it.key.reward}원) - ${it.value}개")
}

private fun printLottery(lottery: List<Int>) {
    println("[${lottery.map { it }.joinToString(LOTTERY_NUMBER_DELIMITER)}]")
}
