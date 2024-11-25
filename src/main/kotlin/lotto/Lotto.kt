package lotto

import lotto.ball.BonusBall
import lotto.number.Numbers

data class Lotto(
    val numbers: Numbers =
        Numbers(
            RANGE
                .shuffled()
                .take(COUNT)
                .sorted(),
        ),
) {
    init {
        require(numbers.numbers.size == COUNT) { "로또 번호는 6개여야 합니다." }
    }

    fun isMatchedBonus(bonusBall: BonusBall): Boolean = numbers.hasNumber(bonusBall.number)

    companion object {
        private const val COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val PRICE: Int = 1_000
        val RANGE = (MIN_NUMBER..MAX_NUMBER).toList()
    }
}
