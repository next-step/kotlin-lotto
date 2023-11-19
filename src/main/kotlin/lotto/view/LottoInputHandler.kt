package lotto.view

object LottoInputHandler {
    private const val LOTTO_WINNING_NUMBERS_DELIMITER = ","

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull().let { require(it != null && it.toIntOrNull() != null) { "구입 금액은 숫자여야 합니다." }; return it.toInt() }
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        readlnOrNull().let {
            require(it != null) { "지난 주 당첨 번호는 숫자여야 합니다." }
            return it.split(LOTTO_WINNING_NUMBERS_DELIMITER).map(::checkStringIsInt)
        }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull().let { require(it != null && it.toIntOrNull() != null) { "보너스 볼은 숫자여야 합니다." }; return it.toInt() }
    }

    fun inputManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull().let { require(it != null && it.toIntOrNull() != null) { "수동으로 구매할 로또 수는 숫자여야 합니다." }; return it.toInt() }
    }

    fun inputManualNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map { readlnOrNull().let { require(it != null) { "수동으로 구매할 번호는 숫자여야 합니다." }; it } }
            .map { it.split(LOTTO_WINNING_NUMBERS_DELIMITER).map(::checkStringIsInt) }
    }

    private fun checkStringIsInt(it: String) =
        it.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
}
