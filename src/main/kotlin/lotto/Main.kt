package lotto

import lotto.domain.LotteryMachine

fun main() {
    val lotteryMachine = LotteryMachine()

    println("구입금액을 입력해 주세요.")
    val payAmount = readLine()?.toIntOrNull() ?: throw IllegalArgumentException()

    val lotteries = lotteryMachine.buyLotteries(payAmount)

    println("${lotteries.count()}개를 구매했습니다.")

    for (it in lotteries.lotteries) {
        println("$it")
    }
    println("지난 주 당첨 번호를 입력해 주세요.")
    val lastWinningLottery = readLine()?.split(",")?.map { it.toInt() }?.toList() ?: throw IllegalArgumentException()

    val result = lotteryMachine.getResult(lotteries, lastWinningLottery)
    println(
        """
        |당첨 통계
        |---------
        |3개 일치 (5000원)- ${result.matchCount(3)}개
        |4개 일치 (50000원)- ${result.matchCount(4)}개
        |5개 일치 (1500000원)- ${result.matchCount(5)}개
        |6개 일치 (2000000000원)- ${result.matchCount(6)}개
        |총 수익률은 ${result.returnRate}입니다.
        """
    )
}
