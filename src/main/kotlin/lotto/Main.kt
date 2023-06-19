package lotto

fun main() {
    val lotteryShop = LotteryShop()
    val money = InputView.requestPurchaseAmount()
    val userLotteryInfo = lotteryShop.buy(money)

    ResultView.printLotteryCount(userLotteryInfo.lotteryCount)
    ResultView.printAllLotteries(userLotteryInfo.lotteryTickets)

    val lastWinnerNumbers = InputView.requestLastWinnerNumbers()
    val lotteryResults = LotteryStatistic.getWinStatistic(userLotteryInfo.lotteryTickets, lastWinnerNumbers)

    ResultView.printWinStatistic(lotteryResults, money)
}