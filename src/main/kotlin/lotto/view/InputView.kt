package lotto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return convertToInt(readLine())
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return convertToListInt(readLine())
    }

    private fun convertToInt(moneyString: String?): Int {
        isNullOrBlank(moneyString)
        return toInt(moneyString!!)
    }

    private fun convertToListInt(winningNumberStr: String?): List<Int> {
        isNullOrBlank(winningNumberStr)
        return winningNumberStr!!.split(",").map { numberStr -> toInt(numberStr) }
    }

    private fun toInt(numberStr: String): Int {
        val number = numberStr.trim().toIntOrNull()
        if (number == null || number < 0) {
            throw RuntimeException("0보다 큰 숫자만 입력해 주세요. numberStr: $numberStr")
        }
        return number
    }

    private fun isNullOrBlank(inputString: String?) = require(!inputString.isNullOrBlank()) { "입력값이 비어있어요." }
}
