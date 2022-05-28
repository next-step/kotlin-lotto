package lotto.domain

class NumberGenerator(range: IntRange) {
    private val numbers: List<Int>

    init {
        numbers = range.toList()
    }

    constructor() : this(LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER)
    constructor(start: Int, end: Int) : this(start..end)

    fun randomTake(count: Int): List<Int> {
        return numbers
            .shuffled()
            .take(count)
    }
}
