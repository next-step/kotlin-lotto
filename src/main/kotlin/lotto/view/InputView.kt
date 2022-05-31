package lotto.view

import lotto.agency.LottoTicket
import lotto.agency.number.LottoNumber
import lotto.exception.AlreadySelectedNumberException
import lotto.exception.NotNumericException

class InputView {
    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")

        val text = readln()
        validateNotString(text)
        return text.toInt()
    }

    fun enterManualLottoPurchaseAmount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val text = readln()
        validateNotString(text)
        return text.toInt()
    }

    fun enterManualLottoTicket(amount: Int): List<Set<Int>> {

        println("수동으로 구매할 번호를 입력해 주세요.")

        val numbers: MutableList<Set<Int>> = mutableListOf()
        repeat(amount) {
            val inputText = readln().trim().split(",")
            numbers.add(inputText.map { it.toInt() }.toSet())
        }

        return numbers
    }

    fun enterWonLottoTicket(): LottoTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val inputText1 = readln().trim().split(",")
        inputText1.map { validateNotString(it) }
        val wonLottoNumbers = inputText1.map { it.toInt() }.toSet()

        println("보너스 볼을 입력해 주세요.")
        val inputText2 = readln()
        validateNotString(inputText2)
        val bonus = inputText2.toInt()

        validateBonus(wonLottoNumbers, bonus)
        val wonLottoTicket = LottoTicket(wonLottoNumbers)
        wonLottoTicket.bonus = LottoNumber(bonus)
        return wonLottoTicket
    }

    private fun validateNotString(toCheck: String) {
        if (toCheck.toIntOrNull() == null) {
            throw NotNumericException("로또 구매를 위해서는 숫자를 입력하셔야 합니다.")
        }
    }

    private fun validateBonus(wonLottoNumber: Set<Int>, bonus: Int) {
        if (wonLottoNumber.contains(bonus)) {
            throw AlreadySelectedNumberException("입력한 보너스 번호는 이미 선택된 번호입니다.")
        }
    }
}
