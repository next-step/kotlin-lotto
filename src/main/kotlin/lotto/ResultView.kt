package lotto

object ResultView {

    fun printLotteryCount(size: Int) {
        println("${size}개를 구매했습니다.")
    }

    fun printAllLotteries(lotteryTickets: List<Lottery>) {
        lotteryTickets.forEach { lottery ->
            println(lottery.numbers)
        }
    }

    fun printWinStatistic(
        lotteryResults: Pair<List<LotteryResult>, Double>,
        money: Int
    ) {
        println("\n당첨 통계\n-------------------")
        lotteryResults.first.forEach { lotteryResult ->
            println(lotteryResult.message)
        }
        println(String.format("총 수익률은 %.2f 입니다", lotteryResults.second / money))
    }
}
