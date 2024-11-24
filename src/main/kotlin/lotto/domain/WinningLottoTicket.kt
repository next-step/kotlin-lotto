package lotto.domain

import lotto.domain.rank.Rank

class WinningLottoTicket(
    val winningNumbers: Set<Int>,
    val bonusNumber: Int,
) {
    init {
        require(winningNumbers.size == 6) {
            "로또 번호는 6개여야 합니다. 입력된 숫자 = $winningNumbers"
        }

        require(winningNumbers.none { it == bonusNumber }) {
            "보너스 번호는 당첨 번호와 중복되면 안됩니다. 중복된 숫자 = $bonusNumber"
        }
    }

    fun matchTickets(lottoTickets: LottoTickets): Map<Rank, Int> {
        val ranks = lottoTickets.tickets.map(::match)
        val eachCount = ranks.groupingBy { it }.eachCount()
        return Rank.entries.associateWith { rank -> eachCount.getOrDefault(rank, 0) }
    }

    fun match(lottoTicket: LottoTicket): Rank {
        val matchCount = lottoTicket.numbers.count { winningNumbers.contains(it.number) }
        val isBonusMatched = lottoTicket.numbers.contains(LottoNumber.of(bonusNumber))
        return Rank.of(matchCount, isBonusMatched)
    }
}
