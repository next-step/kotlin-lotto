package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoFactory.LOTTE_PRICE
import lotto.domain.LottoNumber

object LottoInputView {

    const val NUMBER_SEPARATOR = " "

    /**
     * 로또 구입 금액을 입력 받는다.
     */
    fun inputPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val amount = readln().toInt()
        require(amount >= LOTTE_PRICE) { "로또 1장의 가격은 1000원입니다." }
        return amount
    }

    /**
     * 로또 지난 주 당첨 번호를 입력 받는다.
     */
    fun inputWinningNumbersOfLastWeek(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln()
        require(!numbers.isNullOrBlank()) { "지난 주 당첨 번호를 입력해주세요." }
        return Lotto(getLottoNumbers(numbers))
    }

    /**
     * 로또 지난 주 보너스볼 번호를 입력 받는다.
     */
    fun inputBonusNumberOfLastWeek(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val number = readln()
        require(!number.isNullOrBlank()) { "지난 주 당첨 번호를 입력해주세요." }
        return LottoNumber(number.toInt())
    }

    private fun getLottoNumbers(value: String): Set<LottoNumber> =
        splitNumbers(getOnlyNumbers(value)).map { LottoNumber(it) }.toSet()

    private fun getOnlyNumbers(value: String) = value.replace("[^\\d]".toRegex(), NUMBER_SEPARATOR)

    private fun splitNumbers(value: String) =
        value.split(NUMBER_SEPARATOR).filter { s -> s.isNotBlank() }.map { number -> number.toInt() }
}
