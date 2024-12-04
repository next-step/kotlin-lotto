package lotto.domain.data

@JvmInline
value class Lotto(val value: List<Int>) {
    init {
        require(value.size == MIN_LOTTO_COUNT) { "Number of values must be $MIN_LOTTO_COUNT but was ${value.size}" }
    }

    companion object {
        const val MIN_LOTTO_COUNT = 6
    }
}

fun Lotto.countMatchesOf(lotto: Lotto): Int {
    return this.value.count { lotto.value.contains(it) }
}

fun Lotto.containsAny(number: Int): Boolean {
    return this.value.any { number == it }
}