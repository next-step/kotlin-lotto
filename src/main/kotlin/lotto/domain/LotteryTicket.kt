package lotto.domain

import lotto.data.LottoNumbers
import lotto.data.WinningNumbers
import lotto.enums.LotteryMatchType

class LotteryTicket(val lottoNumbers: LottoNumbers) {
    fun findWinningType(winningNumbers: WinningNumbers): LotteryMatchType {
        return winningNumbers.findWinningType(lottoNumbers)
    }
}
