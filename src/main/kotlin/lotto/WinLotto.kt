package lotto

import lotto.Lotto.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.Lotto.Companion.MINIMUM_LOTTO_NUMBER

class WinLotto {
    val winLotto: Lotto
    val bonusBall: Int

    constructor(winLotto: String?, bonusBall: String?) {
        if (winLotto.isNullOrBlank()) throw IllegalArgumentException("당첨 번호를 입력하세요")
        if (bonusBall.isNullOrBlank()) throw IllegalArgumentException("보너스볼을 입력하세요")

        this.winLotto = Lotto.ofManual(winLotto)
        this.bonusBall = validateBonusBall(bonusBall)
    }

    fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }

    fun matchBonusBall(lotto: Lotto): Boolean {
        return lotto.numbers.contains(bonusBall)
    }

    private fun validateBonusBall(bonusBall: String): Int {
        if (bonusBall.toInt() !in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            throw IllegalArgumentException("${MINIMUM_LOTTO_NUMBER}부터 ${MAXIMUM_LOTTO_NUMBER}까지의 숫자를 입력하세요")
        }
        if (this.winLotto.numbers.contains(bonusBall.toInt())) {
            throw IllegalArgumentException("보너스볼은 당첨 번호와 겹치지 않게 선택해주세요")
        }
        return bonusBall.toInt()
    }
}
