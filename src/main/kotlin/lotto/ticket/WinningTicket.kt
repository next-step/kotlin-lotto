package lotto.ticket

import lotto.result.Rank

class WinningTicket(
    policy: LottoDrawPolicy,
    private val bonusBall: LottoNumber? = null
) {
    private val winningNumbers: Set<LottoNumber> = policy.draw()

    init {
        require(!winningNumbers.contains(bonusBall)) { "보너스 번호 ${this.bonusBall} 와 당첨번호는 같을 수 없습니다" }
    }

    private fun matchLottoNumber(lottoTicket: LottoTicket): Int {
        return winningNumbers.filter {
            lottoTicket.hasWinningNumber(it)
        }.size
    }

    /*
    * step1 bonus ball 없는 게임 지원
    *
    * */
    fun match(lottoTicket: LottoTicket): Rank {
        val matchCount = matchLottoNumber(lottoTicket)
        if (bonusBall == null) {
            return Rank.ofMatchCount(matchCount)
        }
        return Rank.ofMatchInfo(
            matchCount = matchCount,
            hasBonusBall = lottoTicket.hasWinningNumber(bonusBall)
        )
    }

    companion object {
        fun ofTxNumbers(txBonusBall: String, txNumbers: String) = WinningTicket(
            bonusBall = LottoNumber.drawNumber(
                number = txBonusBall.toInt()
            ),
            policy = ManualDrawPolicy(txNumbers)
        )
    }
}
