package lotto.ui

object InputUtils {

    fun splitWinningNumbers(numbersString: String): List<Int> =
        numbersString.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 있습니다. ($it)") }
}
