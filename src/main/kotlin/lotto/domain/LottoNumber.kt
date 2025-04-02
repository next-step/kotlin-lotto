package lotto.domain

class LottoNumber private constructor(
    val value: Int,
) : Comparable<LottoNumber> {
    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45

        private val cache: Map<Int, LottoNumber> = (MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER).associateWith { LottoNumber(it) }
        val cached: Set<Int> = cache.keys

        fun from(number: Int) = cache[number] ?: throw IllegalArgumentException("value must be between 1 and 45 (inclusive)")
    }
}
