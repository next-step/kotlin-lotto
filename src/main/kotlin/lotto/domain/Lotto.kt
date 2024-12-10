package lotto.domain

@JvmInline
value class Lotto(val value: List<LottoNumber>) {
    init {
        require(value.size == LOTTO_COUNT) { "Number of values must be $LOTTO_COUNT but was ${value.size}" }
    }

    fun countMatchesOf(lotto: Lotto): Int {
        return this.value.count { lotto.value.contains(it) }
    }

    fun containsAny(number: LottoNumber): Boolean {
        return this.value.any { number == it }
    }

    companion object {
        const val LOTTO_COUNT = 6
    }
}
