package lotto.domain

import lotto.data.WinningNumbers

class LotteryTicket(val numbers: List<Int>) {
    fun findMatchNumber(winningNumbers: WinningNumbers): Int {
        return numbers.filter { winningNumbers.contains(it) }
            .count()
    }
}
