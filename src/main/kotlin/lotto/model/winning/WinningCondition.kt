package lotto.model.winning

import lotto.model.LottoTicket
import lotto.model.number.LottoNumber
import lotto.model.number.LottoNumbers

data class WinningCondition(val winningNumbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!winningNumbers.isMatch(bonusNumber)) { "보너스 번호와 당첨 번호는 중복될 수 없습니다!" }
    }

    fun check(lottoTicket: LottoTicket): Pair<Int, Boolean> {
        val winningCount = lottoTicket.countMatch(winningNumbers)
        val bonusMatch = lottoTicket.isMatch(bonusNumber)

        return winningCount to bonusMatch
    }
}
