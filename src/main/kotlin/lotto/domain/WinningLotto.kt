package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT

class WinningLotto(private val winningNumbers: Lotto, private val bonusNumber: LottoNumber) {

    init {
        require(!winningNumbers.contains(bonusNumber)) {
            "보너스 볼은 6개의 로또번호와 달라야 합니다."
        }
    }

    fun correctCount(lotto: Lotto): Int {
        lotto.removeAll(winningNumbers)
        return LOTTO_NUMBER_COUNT - lotto.size()
    }

    fun matchedBonusBall(lotto: Lotto): Boolean {
        return lotto.contains(bonusNumber)
    }
}
