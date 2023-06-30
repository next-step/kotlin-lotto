package lotto

class Lotto private constructor(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { "로또 번호는 6개여야 합니다." }
    }

    fun countMatch(other: Lotto): Int {
        return this.numbers.count { other.numbers.contains(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun from(numbers: Set<Int>): Lotto {
            return Lotto(
                numbers = numbers.sorted().map { LottoNumber.build(it) }.toSet()
            )
        }
    }
}
