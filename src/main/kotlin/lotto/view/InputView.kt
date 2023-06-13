package lotto.view

object InputView {

    private const val ENTER_THE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private val ENTER_LAST_WEEK_WINNING_NUMBER = """
        
        반점으로 구분 지어 지난 주 당첨 번호를 입력해 주세요. (ex. 1, 2, 3)
    """.trimIndent()

    fun readPurchaseAmount(): String {
        println(message = ENTER_THE_PURCHASE_AMOUNT)
        return readln()
    }

    fun readLastWeekWinningNumbers(): String {
        println(message = ENTER_LAST_WEEK_WINNING_NUMBER)
        return readln()
    }
}
