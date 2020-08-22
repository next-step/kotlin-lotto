package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object InputView {

    private const val NUMBER_DELIMETER = ","
    private const val INPUT_MONEY_FOR_BUYING = "로또 구입금액을 입력해주세요."
    private const val INPUT_BONUS_NUMBER = "로또 구입금액을 입력해주세요."
    private const val INPUT_MANUAL_BONUS_NUMBER = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val INPUT_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_LUCKY_NUMBER = "지난 주 당첨번호를 입력해주세요."

    tailrec fun getUserInputMoney(): Int {
        println(INPUT_MONEY_FOR_BUYING)
        var money = readLine()?.toIntOrNull()
        return money ?: getUserInputMoney()
    }

    tailrec fun getInputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        val number = readLine()?.toIntOrNull()
        return number ?: getInputBonusNumber()
    }

    tailrec fun getManualLottoCount(): Int {
        println(INPUT_MANUAL_BONUS_NUMBER)
        var numbers = readLine()?.toIntOrNull()
        return numbers ?: getManualLottoCount()
    }

    fun getInputManualLottoNumber(manualNumberCount: Int): List<LottoTicket> {
        println(INPUT_MANUAL_LOTTO_NUMBER)

        val manualNumbers = (1..manualNumberCount).map { inputManualNumber3() }
        return manualNumbers.map { LottoTicket(it) }.toList()
    }

    private fun inputManualNumber3(): List<LottoNumber> {
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(NUMBER_DELIMETER).map { LottoNumber(it.toInt()) }
    }

    fun getInputLuckyNumber(): List<Int> {
        println(INPUT_LUCKY_NUMBER)
        var numbers = readLine()
        while (numbers.isNullOrBlank()) {
            numbers = readLine()
        }
        return numbers.split(NUMBER_DELIMETER).map { it.toInt() }
    }
}
