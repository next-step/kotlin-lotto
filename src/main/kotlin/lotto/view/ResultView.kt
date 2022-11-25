package lotto.view

object ResultView {
    private const val DIV = "---------"
    private const val RATE_FORMAT = "%.2f"

    enum class Message(val context: String) {
        REQUEST_AMOUNT("구입금액을 입력해 주세요."),
        NUMBER_OF_PURCHASES("개를 구매했습니다."),
        REQUEST_LOTTO_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
        REQUEST_BONUS_NUMBERS("보너스 볼을 입력해 주세요."),
        RESULT("당첨 통계");
    }

    fun printMessage(message: Message) = println(message.context)

    fun printMessage(prefix: String, message: Message) = println("$prefix ${message.context}")

    fun printLotto(numbers: List<Int>) = println(numbers)

    fun printResult(matchCount: Int, price: Int, matchBonus: Boolean, resultCount: Int) {
        val bonusMessage: String = if (matchBonus) ", 보너스 볼 일치" else " "

        println("${matchCount}개 일치$bonusMessage(${price}원)- $resultCount")
    }

    fun printIncomeRate(rate: Double) {
        val formattedRate = String.format(RATE_FORMAT, rate)

        println("총 수익률은 ${formattedRate}입니다.")
    }

    fun printDiv() = println(DIV)
}
