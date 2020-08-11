package lotto.domain

class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int = value.compareTo(other.value)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        val NUMBER_RANGE = 1..45
        private val cache = HashMap(NUMBER_RANGE.associateWith { LottoNumber(it) })

        fun take(count: Int): List<LottoNumber> {
            require(count in 0..NUMBER_RANGE.last) { "count는 ${NUMBER_RANGE.last} 이하의 숫자여야 합니다." }
            return cache.map { it.value }.shuffled().take(count)
        }

        operator fun invoke(number: Int): LottoNumber {
            require(number in NUMBER_RANGE) { "로또 번호는 $NUMBER_RANGE 범위 내의 숫자여야 합니다." }
            return cache[number]!!
        }
    }
}
