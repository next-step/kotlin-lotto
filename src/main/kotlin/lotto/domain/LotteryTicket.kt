package lotto.domain

import lotto.data.WinningNumbers

class LotteryTicket(private val numbers: List<Int>) {
    fun findMatchCount(winningNumbers: WinningNumbers): Int {
        return numbers.count { winningNumbers.contains(it) }
    }
}
