package lotto

import java.lang.IllegalArgumentException
import java.lang.NullPointerException
import java.lang.NumberFormatException

object InputView {
    fun getAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readLine()!!
    }

    @Throws(NumberFormatException::class)
    fun checkAmountValidation(amount: String): Int {
        if (amount.isBlank()) throw NullPointerException("값을 입력해 주세요.")
        val result = amount.toInt() / PRICE_OF_LOTTO
        if (amount.toInt() < PRICE_OF_LOTTO) {
            throw IllegalArgumentException("$PRICE_OF_LOTTO 보다 큰 숫자를 입력해주세요.")
        }
        println("$result 개를 구매했습니다.")
        return result
    }

    fun getPrizedNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!
    }
}
