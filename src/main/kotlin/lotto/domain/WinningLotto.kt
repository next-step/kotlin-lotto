package lotto.domain

import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

class WinningLotto(private val winningNumbers: LottoNumbers) {

    fun correctCount(lottoNumbers: LottoNumbers): Int {
        lottoNumbers.removeAll(winningNumbers)
        return LOTTO_NUMBER_COUNT - lottoNumbers.size()
    }
}
