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
}
