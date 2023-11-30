package lotto.domain

@JvmInline
value class Earning(
    private val strategy: Map<MatchCount, Int>
) {

    fun calculate(result: Map<MatchCount, Int>): Int = result
        .filter { strategy.containsKey(it.key) }
        .map { (strategy[it.key]?.times(it.value) ?: 0) }
        .reduceOrNull { acc, i -> acc + i } ?: 0
}
