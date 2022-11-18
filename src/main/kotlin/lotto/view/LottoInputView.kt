package lotto.view

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_RANGE_END
import lotto.domain.LottoFactory.LOTTE_PRICE

object LottoInputView {

    const val NUMBER_SEPARATOR = " "

    fun inputPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln().toInt()
        require(amount >= LOTTE_PRICE) { "로또 1장의 가격은 1000원입니다." }
        return amount
    }

    fun inputWinningNumbersOfLastWeek(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln()
        require(!numbers.isNullOrBlank()) { "지난 주 당첨 번호 6개를 입력해주세요." }

        return getWinningNumbers(numbers)
    }

    fun getWinningNumbers(value: String): Set<Int> {
        val numbers = splitNumbers(getOnlyNumbers(value))
        numbers.map { number ->
            require(number in 1 until LOTTO_NUMBER_RANGE_END + 1) { "로또 번호는 1부터 ${LOTTO_NUMBER_RANGE_END}까지 입니다." }
        }
        return numbers.toSet()
    }

    private fun getOnlyNumbers(value: String) = value.replace("[^\\d]".toRegex(), NUMBER_SEPARATOR)

    private fun splitNumbers(value: String) =
        value.split(NUMBER_SEPARATOR).filter { s -> s.isNotBlank() }.map { number -> number.toInt() }
}
