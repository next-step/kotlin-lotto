package lotto.domain

import lotto.domain.rank.Rank

class LottoTicket(numbers: Set<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개여야 합니다. 입력된 숫자 = $numbers" }
    }

    val numbers = numbers.sorted().map { LottoNumber.of(it) }

    fun match(winningNumbers: Set<LottoNumber>, bonusNumber: LottoNumber): Rank {
        val matchCount = numbers.count { winningNumbers.contains(it) }
        val isBonusMatched = numbers.contains(bonusNumber)
        return Rank.of(matchCount, isBonusMatched)
    }

    companion object {
        fun autoGenerate(): LottoTicket {
            return (1..45).shuffled()
                .take(6)
                .toSet()
                .let { LottoTicket(it) }
        }
    }
}
