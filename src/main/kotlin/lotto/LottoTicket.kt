package lotto

import lotto.LottoNumber.Companion.LOTTO_NUMBER_RANGE

class LottoTicket(var ticketList: List<LottoNumber>) {

    fun validate(winningNumbers: WinningLottoTicket) {
        require(winningNumbers.numbers.size == LOTTO_NUMBER_COUNT)
        require(LOTTO_NUMBER_RANGE.contains(winningNumbers.bonusNumber.number) && !winningNumbers.numbers.contains(winningNumbers.bonusNumber))
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
    }
}
