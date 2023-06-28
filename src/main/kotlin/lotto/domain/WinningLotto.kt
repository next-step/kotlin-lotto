package lotto.domain

import lotto.domain.LottoNumbers.Companion.LOTTO_NUMBER_COUNT

class WinningLotto(private val winningNumbers: LottoNumbers, private val bonusNumber: LottoNumber) {

    init {
        require(!winningNumbers.contains(bonusNumber)) {
            "보너스 볼은 6개의 로또번호와 달라야 합니다."
        }
    }

    fun correctCount(lottoNumbers: LottoNumbers): Int {
        lottoNumbers.removeAll(winningNumbers)
        return LOTTO_NUMBER_COUNT - lottoNumbers.size()
    }

    fun matchedBonusBall(lottoNumbers: LottoNumbers): Boolean {
        return lottoNumbers.contains(bonusNumber)
    }
}
