package lotto.view

import lotto.domain.LottoNumber
import kotlin.IllegalArgumentException
import kotlin.NumberFormatException

object InputView {
    fun inputNumber(): Int {
        return try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("숫자 1개만 입력해주세요.")
        }
    }

    fun inputLottoNumbers(): List<LottoNumber> {
        val inputNumbers = readln()
        val splitNumbers = inputNumbers.split(",")
        return splitNumbers.map { LottoNumber(it.trim().toInt()) }
    }
}
