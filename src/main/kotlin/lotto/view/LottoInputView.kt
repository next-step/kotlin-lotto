package lotto.view

import lotto.domain.Cash
import lotto.domain.Lotto
import lotto.domain.LottoConstants.LOTTE_PRICE
import lotto.domain.LottoNumber
import lotto.domain.Lottos

object LottoInputView {

    const val NUMBER_SEPARATOR = " "

    /**
     * 로또 구입 금액을 입력 받는다.
     */
    fun inputPurchaseAmount(): Cash {
        println("구입 금액을 입력해 주세요.")
        val amount = readln().toInt()
        require(amount >= LOTTE_PRICE) { "로또 1장의 가격은 1000원입니다." }
        println()
        return Cash(amount)
    }

    /**
     * 로또 지난 주 당첨 번호를 입력 받는다.
     */
    fun inputWinningNumbersOfLastWeek(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln()
        require(numbers.isNotBlank()) { "지난 주 당첨 번호를 입력해주세요." }
        return Lotto(getLottoNumbers(numbers))
    }

    /**
     * 로또 지난 주 보너스볼 번호를 입력 받는다.
     */
    fun inputBonusNumberOfLastWeek(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val number = readln()
        require(number.isNotBlank()) { "지난 주 당첨 번호를 입력해주세요." }
        println()
        return LottoNumber(number.toInt())
    }

    /**
     * 수동 구매 로또 수를 입력 받는다.
     */
    fun inputCountOfManualLotto(cash: Cash): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val number = readln()
        if (number.isBlank() || !number.isInt()) {
            println()
            return 0
        }
        val count = number.toInt()
        require(cash.amount >= count * LOTTE_PRICE) { "구입할 수 있는 수를 초과했습니다." }
        println()
        return count
    }

    /**
     * 수동 로또 번호를 입력 받는다.
     */
    fun inputManualLottoNumbers(countOfLotto: Int): Lottos {
        if (countOfLotto == 0) {
            return Lottos()
        }
        println("수동으로 구매할 번호를 입력해 주세요.")

        val numberList = mutableListOf<Set<LottoNumber>>()
        repeat(countOfLotto) {
            val numbers = readln()
            require(numbers.isNotBlank()) { "잘못된 입력입니다." }
            numberList.add(getLottoNumbers(numbers))
        }
        println()
        return Lottos.of(numberList)
    }

    private fun getLottoNumbers(value: String): Set<LottoNumber> =
        splitNumbers(getOnlyNumbers(value)).map { LottoNumber(it) }.toSet()

    private fun getOnlyNumbers(value: String) = value.replace("[^\\d]".toRegex(), NUMBER_SEPARATOR)

    private fun splitNumbers(value: String) =
        value.split(NUMBER_SEPARATOR).filter { s -> s.isNotBlank() }.map { number -> number.toInt() }

    private fun String.isInt(): Boolean = this.toIntOrNull() != null
}
