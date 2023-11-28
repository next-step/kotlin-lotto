package lotto.model

import lotto.model.strategy.LottoNumbersStrategy

@JvmInline
value class LottoGame(
    val values: Set<LottoNumber>,
) {

    init {
        require(values.size == REQUIRE_COUNT_OF_NUMBER) { "${REQUIRE_COUNT_OF_NUMBER}개의 원소가 필요하지만 [${values.size}]개 의 원소가 입력 되었습니다" }
    }

    constructor(values: List<Int>) : this((values.map { LottoNumber(it) }.sortedBy { it.value }).toSet())
    constructor(vararg values: Int) : this(values.toList())
    constructor(strategy: LottoNumbersStrategy) : this(strategy.pick())

    override fun toString(): String {
        return values.map { it.value }
            .joinToString(prefix = "[", postfix = "]", separator = ", ")
    }

    fun numbersIntersections(other: LottoGame): Int {
        return other.values
            .intersect(this.values)
            .size
    }

    fun containNumber(number: LottoNumber): Boolean {
        return values.contains(number)
    }

    companion object {
        const val REQUIRE_COUNT_OF_NUMBER = 6
    }
}

// fun List<LottoNumber>.toTreeSet(): TreeSet<LottoNumber> {
//    return TreeSet(this)
// }
