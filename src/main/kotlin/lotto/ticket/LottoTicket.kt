package lotto.ticket

import lotto.result.Rank

class LottoTicket(
    policy: LottoDrawPolicy
) {
    val lottoNumbers: Set<LottoNumber> = policy.draw()

    fun match(winningTicket: WinningTicket): Rank {
        val matchCount = lottoNumbers.filter { winningTicket.matchNumber(it) }.size
        return Rank.ofMatchCount(matchCount)
    }

    companion object {
        private val AUTO_DRAW_POLICY: LottoDrawPolicy = AutoDrawPolicy()

        fun ofAuto(): LottoTicket {
            return LottoTicket(AUTO_DRAW_POLICY)
        }
    }
}
