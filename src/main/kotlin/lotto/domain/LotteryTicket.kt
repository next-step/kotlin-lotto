package lotto.domain

import lotto.data.WinningNumbers

class LotteryTicket(val lottoNumbers: List<Int>) {

    init {
        require(lottoNumbers.size == 6) { "당첨 숫자의 개수는 6개여야 합니다." }
    }

    fun findMatchCount(winningNumbers: WinningNumbers): Int {
        return lottoNumbers.count { winningNumbers.contains(it) }
    }
}
