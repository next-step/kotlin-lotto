package autolotto.view

object InputView {
    private const val LOTTO_AMOUNT = 1000

    fun getLottoGameCount(amount: Int): Int {
        return amount / LOTTO_AMOUNT
    }

    fun printLottoGameCount(amount: Int) {
        println("${getLottoGameCount(amount)}개를 구매했습니다.")
    }

    fun getLottoPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input: Int = readLine()?.toIntOrNull() ?: throw RuntimeException("0 이 아닌 숫자를 입력해주세요")
        positiveNumber(input)
        lottoAmountValid(input)
        return input
    }

    fun getWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val input: String? = readLine()
        if (input.isNullOrEmpty()) {
            throw RuntimeException("당청번호를 입력해주세요.")
        }
        return splitWinningNumbers(input)
    }

    private fun splitWinningNumbers(input: String): List<Int> {
        return input.split(",").map { e -> e.trim().toInt() }
    }

    private fun positiveNumber(input: Int) {
        require(input >= 0) { "양수가 아닙니다. input=$input" }
    }

    private fun lottoAmountValid(input: Int) {
        require(input >= LOTTO_AMOUNT && input % LOTTO_AMOUNT == 0) { "돈은 ${LOTTO_AMOUNT}원 단위로만 입력 가능합니다." }
    }
}
