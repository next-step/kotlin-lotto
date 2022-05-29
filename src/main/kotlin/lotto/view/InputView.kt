package lotto.view

object InputView {
    fun readLottoPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return convertToLong(readLine())
    }

    fun readWinningNumbers(): List<Long> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return convertToList(readLine())
    }

    private fun convertToLong(moneyStr: String?): Long {
        require(!moneyStr.isNullOrBlank()) { "입력값이 비어있어요." }
        return toNumericLong(moneyStr)
    }

    private fun convertToList(winningNumberStr: String?): List<Long> {
        require(!winningNumberStr.isNullOrBlank()) { "입력값이 비어있어요." }
        return toListString(winningNumberStr).map { number -> toNumericLong(number) }
    }

    private fun toListString(winningNumberStr: String): List<String> {
        val winningNumbers = winningNumberStr.split(",")
        require(winningNumbers.size == 6) { "당첨번호는 6개 숫자가 필요해요." }
        return winningNumbers
    }

    private fun toNumericLong(numberStr: String): Long {
        val number = numberStr.trim().toLongOrNull()
        if (number == null || number < 0) {
            throw RuntimeException("0보다 큰 숫자만 입력해 주세요. numberStr: $numberStr")
        }
        return number
    }
}
