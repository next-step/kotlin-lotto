package lotto

import java.lang.IllegalArgumentException
import java.lang.NullPointerException
import java.lang.NumberFormatException

object InputView {
    fun getCount(): Int {
        println("구입금액을 입력해 주세요.")
        val amount = readLine()!!
        return checkAmountValidation(amount)
    }

    private fun checkAmountValidation(amount: String): Int {
        if (amount.isBlank()) throw NullPointerException("값을 입력해 주세요.")
        try {
            val result = amount.toInt() / PRICE_OF_LOTTO
            println("$result 개를 구매했습니다.")
            return result
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자를 입력해 주세요.")
        }
    }

    fun getPrizedNumbers(): List<Int> {
        println("\n 지난 주 당첨 번호를 입력해 주세요.")
        val prizedNumbers = readLine()!!
        return checkPrizedNumberValidation(prizedNumbers)
    }

    private fun checkPrizedNumberValidation(prizedNumbers: String): List<Int> {
        if (prizedNumbers.isBlank()) throw NullPointerException("값을 입력해 주세요.")
        try {
            return prizedNumbers.replace(" ", "").split(",").map { it.toInt() }
        } catch (e: NumberFormatException) {
            throw NumberFormatException("숫자를 입력해 주세요.")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("구분자는 `,`만 가능합니다.")
        }
    }
}
