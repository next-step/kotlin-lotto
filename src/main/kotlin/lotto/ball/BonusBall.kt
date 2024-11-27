package lotto.ball

import lotto.number.LottoNumber
import lotto.number.LottoNumber.Companion.MAX_NUMBER
import lotto.number.LottoNumber.Companion.MIN_NUMBER
import lotto.number.Numbers

class BonusBall(
    val number: LottoNumber,
) {
    init {
        require(number.number in MIN_NUMBER..MAX_NUMBER) { "보너스 볼 번호는 ${MIN_NUMBER}와 ${MAX_NUMBER}사이여야 합니다." }
    }

    fun isNotDuplicated(winningNumber: Numbers): Boolean = !winningNumber.hasNumber(number)
}
