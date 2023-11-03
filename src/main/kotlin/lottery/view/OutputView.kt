package lottery.view

object OutputView {
    private const val PRINT_LOTTERY_AMOUNT_MESSAGE = "개를 구매했습니다."

    fun printLotteryAmount(amount: Int) {
        println("$amount$PRINT_LOTTERY_AMOUNT_MESSAGE")
    }
}