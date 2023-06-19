package lottery.view

import lottery.domain.LottoResult
import lottery.domain.lottery.Lottery
import lottery.domain.lottery.PurchasedLotteriesResult
import lottery.domain.rank.Rank

private const val LOTTERY_NUMBER_DELIMITER = ", "

fun printPurchaseLotteries(purchasedLotteriesResult: PurchasedLotteriesResult) {
    println("수동으로 ${purchasedLotteriesResult.manualCount}장, 자동으로 ${purchasedLotteriesResult.randomCount}개를 구매했습니다.")
    purchasedLotteriesResult.purchasedAllLotteries.forEach { printLottery(it) }
}

fun printLottoResult(lottoResult: LottoResult) {
    println("당첨 통계")
    println("---------")
    lottoResult.statistics
        .forEach { printStatistic(it) }
    println("총 수익률은 ${lottoResult.lottoYield.setScale(2)}입니다.")
}

private fun printStatistic(it: Map.Entry<Rank, Int>) {
    if (it.key == Rank.SECOND) {
        println("${it.key.equalCount}개 일치, 보너스 볼 일치(${it.key.reward}원) - ${it.value}개")
        return
    }
    println("${it.key.equalCount}개 일치 (${it.key.reward}원) - ${it.value}개")
}

private fun printLottery(lottery: Lottery) {
    println("[${lottery.values.map { it.value }.joinToString(LOTTERY_NUMBER_DELIMITER)}]")
}
