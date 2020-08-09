package lotto.view

import lotto.domain.*
import lotto.domain.Number

object InputView {

    fun inputMoney(): Money {
        println("금액을 입력해주세요")
        return Money(readLine())
    }

    fun inputManualLottoAmount(totalAmount: Int): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val amount = changeInt(checkNullOrBlank(readLine()))
        if (amount > totalAmount ) {
            throw IllegalArgumentException("구매하신 로또는 ${totalAmount}장 입니다. 구매하신 로또보다 많은 량을 입력하셨습니다.")
        }
        return amount
    }

    fun inputManualLotto(amount: Amount): List<Lotto> {
        if (amount.manual == 0 ){
            return listOf()
        }
        println("수동으로 구매할 로또 번호를 입력해주세요")
        return (1..amount.manual).map {
            Lotto(checkSameNumber(checkNullOrBlank(readLine()).split(",").map { changeInt(it)}).toSet())
        }
    }

    fun inputCorrectLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Lotto(checkSameNumber(checkNullOrBlank(readLine()).split(",").map { changeInt(it)}).toSet())
    }

    fun inputBonusBall(correctLotto: Lotto): WinningLotto {
        println("보너스 볼을 입력해 주세요.")
        val number = changeInt(checkNullOrBlank(readLine()))
        return WinningLotto(correctLotto, Number.getNumber(number))
    }

    private fun checkNullOrBlank(string: String?): String {
        if (string.isNullOrBlank()) {
            throw IllegalArgumentException("공백값과 null값은 입력할수없습니다.")
        }
        return string
    }

    private fun changeInt(inputValue: String): Int {
        try {
            return inputValue.trim().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자 이외의 값은 입력할수없습니다.")
        }
    }

    private fun checkSameNumber(numbers: List<Int>): List<Int> {
        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException("같은 번호는 입력할수없습니다.")
        }
        return numbers
    }
}
