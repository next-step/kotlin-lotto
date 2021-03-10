package lotto.domain

import lotto.data.WinningNumbers

class LotteryTicket(val lottoNumbers: List<Int>) {
    fun findMatchCount(winningNumbers: WinningNumbers): Int {
        return lottoNumbers.count { winningNumbers.contains(it) }
    }
}
