package lotto

import lotto.ball.BonusBall
import lotto.number.LottoNumber
import lotto.number.Numbers
import lotto.number.Numbers.Companion.sorted

data class Lotto(
    val numbers: Numbers =
        Numbers(
            LottoNumber.RANGE
                .shuffled()
                .take(COUNT)
                .sorted(),
        ),
) {
    init {
        require(numbers.numbers.size == COUNT) { "로또 번호는 ${COUNT}개여야 합니다." }
    }

    fun isMatchedBonus(bonusBall: BonusBall): Boolean = numbers.hasNumber(bonusBall.number)

    companion object {
        const val PRICE: Int = 1_000
        private const val COUNT = 6
    }
}
