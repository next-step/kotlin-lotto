package lotto.model

import lotto.model.LottoNumber.Companion.LOTTO_NUMBERS

class Lotto(
    private val lotto: List<LottoNumber>
) {

    fun findMatchedNumberCount(other: Lotto) = other.lotto.count { lotto.contains(it) }

    override fun toString(): String {
        return "$lotto"
    }

    companion object {
        fun of(numbers: List<Int>): Lotto {
            validateUnique(numbers)

            val lottoNumbers = numbers.map { LOTTO_NUMBERS[it - 1] }
            return Lotto(lottoNumbers)
        }

        private fun validateUnique(numbers: List<Int>) {
            require(numbers.size == numbers.toSet().size) { "로또에 중복되는 번호가 있을 수 없습니다." }
        }
    }
}
