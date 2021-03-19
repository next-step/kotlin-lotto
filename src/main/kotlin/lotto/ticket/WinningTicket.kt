package lotto.ticket

import lotto.result.Rank

class WinningTicket(
    policy: LottoDrawPolicy,
    private val bonusBall: LottoNumber
) {
    private val lottoNumbers: Set<LottoNumber> = policy.draw()

    init {
        require(!lottoNumbers.contains(bonusBall)) { "보너스 번호 ${this.bonusBall} 와 당첨번호는 같을 수 없습니다" }
    }

    fun match(lottoTicket: LottoTicket): Rank = Rank.ofMatchInfo(
        matchCount = lottoNumbers.filter {
            lottoTicket.hasLottoNumber(it)
        }.size,
        hasBonusBall = lottoTicket.hasLottoNumber(bonusBall)
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
