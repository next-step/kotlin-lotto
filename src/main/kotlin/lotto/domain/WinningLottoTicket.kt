package lotto.domain

import lotto.Rank

class WinningLottoTicket(
    val winningNumbers: Set<Int>,
    val bonusNumber: Int
) {
    fun match(lottoTicket: LottoTicket): Rank {
        val matchCount = lottoTicket.numbers.count { winningNumbers.contains(it.number) }
        val isBonusMatched = lottoTicket.numbers.contains(LottoNumber.of(bonusNumber))
        return Rank.of(matchCount, isBonusMatched)
    }

    init {
        require(winningNumbers.size == 6) {
            "로또 번호는 6개여야 합니다."
        }

        require(winningNumbers.none { it == bonusNumber }) {
            "보너스 번호는 당첨 번호와 중복되면 안됩니다."
        }
    }
}
