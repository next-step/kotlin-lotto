package lotto.domain

import lotto.data.LottoNumbers

class LotteryTicket(val lottoNumbers: LottoNumbers) {
    fun findMatchCount(winningNumbers: LottoNumbers): Int {
        return lottoNumbers.findMatchCount(winningNumbers)
    }
}
