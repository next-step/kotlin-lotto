package lotto.domain

@JvmInline
value class Earning(
    private val strategy: Map<Int, Int>
) {

    fun calculate(result: Map<Int, Int>): Int = result
        .filter { strategy.containsKey(it.key) }
        .map { (strategy[it.key]!! * (it.value)) }
        .reduceOrNull { acc, i -> acc + i } ?: 0
}
