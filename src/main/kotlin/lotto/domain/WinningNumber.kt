package lotto.domain

import lotto.Const

class WinningNumber {
    fun winningNumberToLottoTicket(winningNumbers: List<Int>): LottoTicket {
        val lottoNumbers = winningNumbers.map { LottoNumber(it) }.toSet()
        return LottoTicket(lottoNumbers)
    }

    fun validBonusNumber(bonusNumber: LottoNumber, lottoTicket: LottoTicket) {
        require(!lottoTicket.hasNumber(bonusNumber)) { Const.ErrorMsg.INVALID_BONUS_NUMBER_ERROR_MSG }
    }
}
