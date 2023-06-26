package lotto.domain

import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_6

class Lotto private constructor(
    private val numbers: List<LottoNumber>,
    private val auto: Boolean = false
) {
    private val sortedNumbers = numbers.map { it.number }.sorted()

    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { LOTTO_NUMBERS_MUST_BE_6 }
    }

    override fun toString(): String {
        return "[${sortedNumbers.joinToString(", ") { it.toString() }}]"
    }

    fun numberOfMatch(winningLotto: WinningLotto): Int {
        val otherNumbers = winningLotto.lotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    fun isCatchBonus(winningLotto: WinningLotto): Boolean = numbers.contains(winningLotto.bonusNumber)

    fun isAuto(): Boolean = auto

    companion object {
        const val NUMBER_OF_LOTTO_NUMBERS: Int = 6

        fun autoCreate(): Lotto {
            val lottoNumbers = LottoNumber.createRandomList(NUMBER_OF_LOTTO_NUMBERS)
            return Lotto(lottoNumbers, true)
        }

        fun manualCreate(numbers: List<Int>): Lotto {
            val lottoNumbers = numbers.map {
                LottoNumber.create(it)
            }
            return Lotto(lottoNumbers)
        }
    }
}
