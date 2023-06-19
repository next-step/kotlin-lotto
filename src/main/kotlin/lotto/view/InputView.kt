package lotto.view

import kotlin.NumberFormatException

private const val UNIT = 1000
object InputView {
    fun getPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getLastWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun parseWinningNumbers(input: String): List<Int> {
        return try {
            input.split(",").map { it.trim().toInt() }
        } catch(e: NumberFormatException) {
            throw NumberFormatException("지난주 당첨 번호를 숫자와 콤마(,)로 구분하여 다시 입력해주시기 바랍니다. ")
        }
    }
}
