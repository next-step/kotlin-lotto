package lotto.view

object InputView {
    fun getPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        return convertToLong(readLine())
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return convertToListInt(readLine())
    }

    fun getBonusNumber(): Int {
        println("\n보너스 볼을 입력해 주세요.")
        return convertToInt(readLine())
    }

    private fun convertToInt(bonusNumber: String?): Int {
        bonusNumber.checkNullOrBlank()
        return bonusNumber!!.toNumericInt()
    }

    private fun convertToLong(moneyString: String?): Long {
        moneyString.checkNullOrBlank()
        return moneyString!!.toNumericLong()
    }

    private fun convertToListInt(winningNumberStr: String?): List<Int> {
        winningNumberStr.checkNullOrBlank()
        return winningNumberStr!!.split(",").map { it.toNumericInt() }
    }
}

fun String?.checkNullOrBlank() = require(!this.isNullOrBlank()) { "입력값이 비어있어요." }

fun String.toNumericInt(): Int {
    val number = this.trim().toIntOrNull() ?: throw IllegalArgumentException("잘못된 숫자 입력입니다.")
    require(number > 0) { "0보다 큰 숫자만 입력해 주세요. inputMoney: $this" }
    return number
}

fun String.toNumericLong(): Long {
    val number = this.trim().toLongOrNull() ?: throw IllegalArgumentException("잘못된 숫자 입력입니다.")
    require(number > 0L) { "0보다 큰 숫자만 입력해 주세요. inputMoney: $this" }
    return number
}
