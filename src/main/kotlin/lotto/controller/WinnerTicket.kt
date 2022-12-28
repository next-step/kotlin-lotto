package lotto.controller

import lotto.model.LottoNumber
import lotto.model.LottoTicket
import lotto.model.Rank

class WinnerTicket {
    fun generate(winnerNumber: String, bonusNumber: String): Pair<LottoTicket, LottoNumber> {
        val winnerTicket = LottoTicket(winnerNumber)
        val bonusNumbers = LottoNumber(bonusNumber)
        require(bonusNumbers.value !in winnerTicket.values) { "보너스 번호와 당첨 번호는 중복 될 수 없습니다." }
        return winnerTicket to bonusNumbers
    }

    fun getRank(lottoTicket: LottoTicket, winnerTicket: LottoTicket, bonusNumber: Int): Rank {
        val winnerNumberCount = lottoTicket.values.toSet().intersect(winnerTicket.values.toSet()).size
        return Rank.of(winnerNumberCount, isMatchBonusNumber(bonusNumber))
    }

    private fun isMatchBonusNumber(bonusNumber: Int): Boolean {
        return bonusNumber != 0
    }
}
