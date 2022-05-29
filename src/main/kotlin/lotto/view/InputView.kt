package lotto.view

import lotto.agency.LottoNumber
import lotto.agency.LottoTicket
import lotto.exception.AlreadySelectedNumberException
import lotto.exception.NotNumericException

class InputView {
    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")

        val text = readln()
        validateNotString(text)
        return text.toInt()
    }

    fun enterWonLottoTicket(): LottoTicket {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val inputText1 = readln().trim().split(",")
        inputText1.map { validateNotString(it) }
        val wonLottoNumbers = inputText1.map { it.toInt() }.map { LottoNumber(it) }

        println("보너스 볼을 입력해 주세요.")
        val inputText2 = readln()
        validateNotString(inputText2)
        val bonus = LottoNumber(inputText2.toInt())

        validateBonus(wonLottoNumbers, bonus)
        return LottoTicket(wonLottoNumbers, bonus)
    }

    private fun validateNotString(toCheck: String) {
        if (toCheck.toIntOrNull() == null) {
            throw NotNumericException("로또 구매를 위해서는 숫자를 입력하셔야 합니다.")
        }
    }

    private fun validateBonus(wonLottoNumber: List<LottoNumber>, bonus: LottoNumber) {
        if (wonLottoNumber.contains(bonus)) {
            throw AlreadySelectedNumberException("입력한 보너스 번호는 이미 선택된 번호입니다.")
        }
    }
}
