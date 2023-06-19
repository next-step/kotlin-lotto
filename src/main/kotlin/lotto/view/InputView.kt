package lotto.view

import lotto.domain.LottoNumber
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

object InputView {

    fun inputPayment(): Int {
        return try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자만 입력해주세요.")
        }
    }

    fun inputWinnerNumbers(): List<LottoNumber> {
        val inputNumbers = readln()
        val splitNumbers = inputNumbers.split(",")
        return splitNumbers.map { LottoNumber(it.trim().toInt()) }
    }
}
