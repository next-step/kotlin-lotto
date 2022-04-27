package lotto.domain.ticket

import lotto.domain.matching.LottoMatching
import lotto.domain.ticket.lottery.LotteryNumbers

data class WinningLottoNumbers(private val _lotteryNumbers: LotteryNumbers) {
    val values: List<Int>
        get() = _lotteryNumbers.values

    fun numberOfMatchesWithWinningNumbers(otherLottoGame: LottoGame): LottoMatching {
        val numberOfMatches = otherLottoGame.value
            .count { lotteryNumber ->
                lotteryNumber in _lotteryNumbers.values
            }

        return LottoMatching.from(numberOfMatches)
    }
}
