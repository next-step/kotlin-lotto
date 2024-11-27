package lotto.domain

class LottoNumbers(numbers: Set<LottoNumber>) {
    val numbers: Set<LottoNumber>

    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 $LOTTO_NUMBER_COUNT 개이어야 합니다" }
        this.numbers = numbers.sortedBy { it.number }.toSet()
    }

    fun countMatchedNumber(other: LottoNumbers): Int {
        return (numbers intersect other.numbers).size
    }

    fun containsNumber(other: LottoNumber): Boolean {
        return numbers.contains(other)
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6

        fun create(): LottoNumbers {
            return LottoNumbers(LottoNumber.ALL.shuffled().take(LOTTO_NUMBER_COUNT).toSet())
        }

        fun from(numbers: Set<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber(it) }.toSet())
        }
    }
}
