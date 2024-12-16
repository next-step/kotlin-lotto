package lotto.domain

data class LottoNumbers(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { IllegalArgumentException::class.java }
    }

    fun contains(number: LottoNumber): Boolean = numbers.contains(number)

    companion object {
        const val LOTTO_NUMBER_COUNT = 6

        fun from(values: List<Int>): LottoNumbers = LottoNumbers(values.map { LottoNumber.from(it) }.toSet())
    }
}
