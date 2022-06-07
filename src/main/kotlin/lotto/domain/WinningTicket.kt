package lotto.domain

class WinningTicket(private val lottoTicket: LottoTicket, val bonusNumber: Int) {
    init {
        require(!lottoTicket.lottoNumbers.map { it.number }.contains(bonusNumber)) { "보너스 번호가 로또 번호와 중복됩니다." }
    }
    val numbers = lottoTicket.lottoNumbers.map { it.number }

//    fun priority(winningTicket: WinningTicket): Priority {
//        val matchCount = calculateMatch(winningTicket)
//        return if (isBonusTicket(matchCount, winningTicket.bonusNumber)) Priority.SECOND else Priority.find(matchCount)
//    }
//
//    private fun calculateMatch(winningTicket: WinningTicket): Int {
//        return lottoNumbers.map { it.number }.filter { winningTicket.numbers.contains(it) }.size
//    }
//
//    private fun isBonusTicket(matchCount: Int, bonusNumber: Int): Boolean {
//        return lottoNumbers.map { it.number }.contains(bonusNumber) && matchCount == LottoTicket.BONUS_CANDIDATE_COUNT
//    }
}
