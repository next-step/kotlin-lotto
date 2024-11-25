package lotto.ball

import lotto.Lotto
import lotto.number.Numbers

class BonusBall(
    val number: Int,
) {
    init {
        require(Lotto.RANGE.contains(number)) { "보너스 볼 번호는 ${Lotto.MIN_NUMBER}와 ${Lotto.MAX_NUMBER}사이여야 합니다." }
    }

    fun isNotDuplicated(winningNumber: Numbers): Boolean = winningNumber.hasNumber(number)
}
