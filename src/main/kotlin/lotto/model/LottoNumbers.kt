package lotto.model

import lotto.model.strategy.LottoNumberStrategy

@JvmInline
value class LottoNumbers private constructor(
    private val values: LinkedHashSet<LottoNumber>,
) {
    init {
        require(values.size == REQUIRE_COUNT_OF_NUMBER) { "${REQUIRE_COUNT_OF_NUMBER}개의 원소가 필요하지만 [${values.size}]개 의 원소가 입력 되었습니다" }
    }

    constructor(values: List<Int>) : this(LinkedHashSet(values.map { LottoNumber(it) }.sortedBy { it.value }))
    constructor(vararg values: Int) : this(values.toList())
    constructor(strategy: LottoNumberStrategy) : this(generateNumbersWithStrategy(strategy))

    override fun toString(): String {
        return values.map { it.value }
            .joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    fun numbersIntersections(other: LottoNumbers): Int {
        return other.values
            .intersect(this.values)
            .size
    }

    fun containNumber(number: LottoNumber): Boolean {
        return values.contains(number)
    }

    companion object {

        private const val REQUIRE_COUNT_OF_NUMBER = 6

        private fun generateNumbersWithStrategy(strategy: LottoNumberStrategy): LinkedHashSet<LottoNumber> {
            val numbers = LinkedHashSet<LottoNumber>()
            while (isEnoughCountOfNumber(numbers)) {
                numbers.add(strategy.pick())
            }
            return numbers
        }

        private fun isEnoughCountOfNumber(numbers: java.util.LinkedHashSet<LottoNumber>): Boolean {
            return numbers.size < REQUIRE_COUNT_OF_NUMBER
        }
    }
}
