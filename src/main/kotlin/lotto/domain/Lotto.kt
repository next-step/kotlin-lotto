package lotto.domain

import lotto.domain.LottoErrorMessage.LOTTO_NUMBERS_MUST_BE_6

class Lotto private constructor(
    val numbers: List<LottoNumber>,
    val auto: Boolean = false
) {
    init {
        require(numbers.size == NUMBER_OF_LOTTO_NUMBERS) { LOTTO_NUMBERS_MUST_BE_6 }
    }

    fun numberOfMatch(winningLotto: WinningLotto): Int {
        val otherNumbers = winningLotto.lotto.numbers
        return otherNumbers.intersect(numbers.toSet()).count()
    }

    fun isCatchBonus(winningLotto: WinningLotto): Boolean = numbers.contains(winningLotto.bonusNumber)

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
