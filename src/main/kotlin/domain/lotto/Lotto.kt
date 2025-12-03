package domain.lotto

data class Lotto(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == SIZE) {
            "A lotto must contain exactly $SIZE unique numbers."
        }
    }

    companion object {
        const val SIZE = 6

        fun fromNumbers(vararg numbers: Int): Lotto = Lotto(numbers.map { LottoNumber(it) }.toSet())
    }
}
