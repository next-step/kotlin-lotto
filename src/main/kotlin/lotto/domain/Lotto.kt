package lotto.domain

import lotto.domain.LottoNumber.Companion.LOTTO_NUMBERS

class Lotto(
    val numbers: List<LottoNumber>
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { "로또 번호는 6개여야 합니다." }
    }

    fun checkEqualCount(anotherLotto: Lotto): Int {
        val otherNumbers = anotherLotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    companion object {
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun auto(): Lotto {
            val numbers = LOTTO_NUMBERS.shuffled().take(NUMBER_OF_LOTTO_NUMBERS).map { LottoNumber(it) }
            return Lotto(numbers)
        }
    }
}
