package lotto.domain

class LottoNumbers(numbers: Set<LottoNumber>) {
    val numbers: Set<LottoNumber> = numbers.toSortedSet()

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 $LOTTO_NUMBER_COUNT 개이어야 합니다" }
    }

    fun countMatchedNumber(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }

    operator fun contains(other: LottoNumber): Boolean {
        return other in numbers
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun random(): LottoNumbers {
            return LottoNumbers(LottoNumber.ALL.shuffled().take(LOTTO_NUMBER_COUNT).toSet())
        }

        fun from(numbers: Set<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) }.toSet())
        }
    }
}
