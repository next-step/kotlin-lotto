package lottery

class LotteryGameView {
    fun printPurchaseMoneyView() {
        println("구입 금액을 입력해 주세요.")
    }

    fun printPurchaseLotteryView(number: Int) {
        println("{$number}개를 구매했습니다.")
    }

    fun printLotteriesNumber(lotteries: Lotteries) {
        lotteries.lotteries.forEach {
            println(it.lotteryNumbers)
        }
    }

    fun printWinnerLotteryNumber() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }

    fun printLotteryRankView(lotteryRank: LotteryRank) {
        println("당첨 통계")
        println("---------")
        lotteryRank.lotteriesRank.forEach { (prize, number) ->
            println("${prize.correctCount}개 일치 (${prize.rewardMoney}원)- ${number}개")
        }
    }

    fun printProfitView(profit: Float) {
        println("총 수익률은 ${profit}입니다.")
    }
}
