package lotto.domain

class WinningTicket(val lottoTicket: LottoTicket, val bonusNumber: Int) {
    init {
        require(!lottoTicket.hasBonusNumber(bonusNumber)) { "보너스 번호가 로또 번호와 중복됩니다." }
    }

    fun calculateMatch(ticket: LottoTicket): Int {
        return ticket.matchCount(lottoTicket)
    }

    fun isBonusTicket(ticket: LottoTicket, matchCount: Int): Boolean {
        val lottoNumbers = ticket.lottoNumbers.map { it.number }
        return lottoNumbers.contains(bonusNumber) && matchCount == BONUS_CANDIDATE_COUNT
    }

    companion object {
        private const val BONUS_CANDIDATE_COUNT = 4
    }
}
