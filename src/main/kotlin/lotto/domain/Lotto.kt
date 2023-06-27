package lotto.domain

import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_6
import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_UNIQUE

class Lotto private constructor(
    private val numbers: List<LottoNumber>
) {

    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { LOTTO_NUMBERS_MUST_BE_6 }
        require(numbers.toSet().size == numbers.size) { LOTTO_NUMBERS_MUST_BE_UNIQUE }
    }

    override fun toString(): String {
        return "[${sortedNumbers().joinToString(", ") { it.toString() }}]"
    }

    fun numberOfMatch(winningLotto: WinningLotto): Int {
        val otherNumbers = winningLotto.lotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    fun isCatchBonus(winningLotto: WinningLotto): Boolean = numbers.contains(winningLotto.bonusNumber)

    private fun sortedNumbers() = numbers.map { it.number }.sorted()

    companion object {
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun autoCreate(): Lotto {
            val lottoNumbers = LottoNumber.createRandoms(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(lottoNumbers)
        }

        fun manualCreate(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map {
                LottoNumber.create(it)
            }
            return Lotto(lottoNumbers)
        }
    }
}
