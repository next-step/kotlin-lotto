package lotto.domain

class LottoNumber(
    val number: Int
) {
    init {
        validate()
    }

    private fun validate() {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw IllegalArgumentException("로또 번호는 ${MIN_NUMBER}보다 크고 ${MAX_NUMBER}보다 작아야 합니다. number:$number")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (number != other.number) return false

        return true
    }

    override fun hashCode(): Int {
        return number
    }

    object LottoCache {
        private val cache = Array(MAX_NUMBER) { LottoNumber(it + MIN_NUMBER) }

        fun get(number: Int): LottoNumber {
            return cache[number - 1]
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45

        fun of(number: Int): LottoNumber {
            return try {
                LottoCache.get(number)
            } catch (e: IndexOutOfBoundsException) {
                LottoNumber(number)
            }
        }
    }
}
