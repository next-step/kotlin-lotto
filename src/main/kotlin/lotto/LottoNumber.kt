package lotto

data class LottoNumber(private val numbers: List<Int>) : List<Int> by numbers {
    init {
        require(numbers.toSet().size == NUMBER_COUNT)
    }

    constructor(range: IntRange) : this(range.toList())

    constructor(vararg numbers: Int) : this(numbers.toList())

    companion object {
        const val NUMBER_COUNT: Int = 6

        fun from(source: Set<Int>): LottoNumber {
            return LottoNumber(source.take(NUMBER_COUNT))
        }
    }
}
