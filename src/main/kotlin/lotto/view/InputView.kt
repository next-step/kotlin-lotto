package lotto.view

object InputView {

    private const val ENTER_THE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private val ENTER_LAST_WEEK_WINNING_NUMBER = """
        
        반점으로 구분 지어 지난 주 당첨 번호를 입력해 주세요. (ex. 1, 2, 3)
    """.trimIndent()

    private const val ENTER_BONUS_BALL = "보너스 볼을 입력해 주세요."

    private val ENTER_MANUAL_LOTTERY_COUNT = """
        
        수동으로 구매할 로또 수를 입력해 주세요.
    """.trimIndent()

    private val ENTER_MANUAL_LOTTERY_NUMBERS = """

        수동으로 구매할 번호를 입력해 주세요.
    """.trimIndent()

    fun readPurchaseAmount(): String {
        println(message = ENTER_THE_PURCHASE_AMOUNT)
        return readln()
    }

    fun readManualLotteryNumber(): List<String> {
        println(message = ENTER_MANUAL_LOTTERY_COUNT)

        val manualLotteryCount = readln().toInt()

        println(message = ENTER_MANUAL_LOTTERY_NUMBERS)

        return List(manualLotteryCount) { readln() }
    }

    fun readLastWeekWinningNumbers(): String {
        println(message = ENTER_LAST_WEEK_WINNING_NUMBER)
        return readln()
    }

    fun readBonusBall(): String {
        println(message = ENTER_BONUS_BALL)
        return readln()
    }
}
