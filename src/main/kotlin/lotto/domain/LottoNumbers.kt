package lotto.domain

data class LottoNumbers(private val numbers: List<Int>) : List<Int> by numbers {
    init {
        require(numbers.toSet().size == NUMBER_COUNT)
    }

    constructor(range: IntRange) : this(range.toList())

    constructor(vararg numbers: Int) : this(numbers.toList())

    companion object {
        const val NUMBER_COUNT: Int = 6

        fun from(source: Set<Int>): LottoNumbers {
            return LottoNumbers(source.take(NUMBER_COUNT))
        }
    }
}
