package lotto.model

import lotto.model.number.CandidateNumber
import lotto.model.number.WinningNumbers

data class WinningCondition(val winningNumbers: WinningNumbers, val bonusNumber: CandidateNumber) {
    fun check(lottoTicket: LottoTicket): Pair<Int, Boolean> {
        val winningCount = lottoTicket.countMatch(winningNumbers)
        val bonusMatch = lottoTicket.isMatch(bonusNumber)

        return Pair(winningCount, bonusMatch)
    }

    init {
        require(winningNumbers.all { it != bonusNumber }) { "보너스 번호와 당첨 번호는 중복될 수 없습니다!" }
    }
}
