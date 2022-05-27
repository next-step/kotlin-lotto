package lotto.view

import lotto.agency.LottoNumber
import lotto.agency.LottoTicket
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

        val text = readln().trim().split(",")
        text.map { validateNotString(it) }
        val wonLottoNumbers = text.map { it.toInt() }.map { LottoNumber(it) }

        return LottoTicket(wonLottoNumbers)
    }

    fun enterBonusLottoNumber(wonLottoTicket: LottoTicket): Int {
        println("보너스 볼을 입력해 주세요.")

        val text = readln()
        validateNotString(text)
        val bonusLottoNumber = text.toInt()
        validateBonusLottoTicket(wonLottoTicket, LottoNumber(bonusLottoNumber))
        return bonusLottoNumber
    }

    private fun validateNotString(toCheck: String) {
        if (toCheck.toIntOrNull() == null) {
            throw NotNumericException("로또 구매를 위해서는 숫자를 입력하셔야 합니다.")
        }
    }

    private fun validateBonusLottoTicket(wonLottoTicket: LottoTicket, bonusLottoNumber: LottoNumber) {
        wonLottoTicket.validateDuplicate(bonusLottoNumber)
    }
}
