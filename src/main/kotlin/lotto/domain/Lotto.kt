package lotto.domain

class Lotto(
    private val numbers: Set<LottoNumber>
) {
    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS) { "로또 번호의 개수는 반드시 $SIZE_OF_LOTTO_NUMBERS 개 이어야 합니다" }
    }

    override fun toString(): String {
        return numbers.toList()
            .sorted()
            .toString()
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in numbers
    }

    fun countMatchingNumbers(other: Lotto): Int {
        return numbers.intersect(other.numbers).size
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6

        fun of(numbers: Collection<Int>): Lotto {
            val numberSet = numbers.map { LottoNumber(it) }
                .toSet()
            return Lotto(numberSet)
        }
    }
}
