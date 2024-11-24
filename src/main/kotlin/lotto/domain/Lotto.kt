package lotto.domain

class Lotto(
    private val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_SIZE) { "로또는 6개의 숫자를 가져야 합니다." }
    }

    val sortedNumbers: List<Int> = numbers.map(LottoNumber::value).sorted()

    fun compare(other: Lotto): Int {
        return numbers.count { it in other.numbers }
    }

    companion object {
        private const val LOTTO_SIZE = 6

        fun of(numbers: List<Int>): Lotto = Lotto(numbers.map(::LottoNumber).toSet())
    }
}
