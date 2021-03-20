package lotto.ticket

import lotto.result.Rank

class WinningTicket(
    policy: LottoDrawPolicy,
    private val bonusBall: LottoNumber
) {
    private val winningNumbers: Set<LottoNumber> = policy.draw()

    init {
        require(!winningNumbers.contains(bonusBall)) { "보너스 번호 ${this.bonusBall} 와 당첨번호는 같을 수 없습니다" }
    }

    fun match(lottoTicket: LottoTicket): Rank = Rank.ofMatchInfo(
        matchCount = winningNumbers.filter {
            lottoTicket.hasWinningNumber(it)
        }.size,
        hasBonusBall = lottoTicket.hasWinningNumber(bonusBall)
    )

    companion object {
        fun ofTxNumbers(txBonusBall: String, txNumbers: String) = WinningTicket(
            bonusBall = LottoNumber.drawNumber(
                number = txBonusBall.toInt()
            ),
            policy = ManualDrawPolicy(txNumbers)
        )
    }
}
