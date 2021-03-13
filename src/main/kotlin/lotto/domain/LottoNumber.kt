package lotto.domain

data class LottoNumber(
    val number: Int
) {
    init {
        validate()
    }

    private fun validate() {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            "로또 번호는 ${MIN_NUMBER}보다 크고 ${MAX_NUMBER}보다 작아야 합니다. number:$number"
        }
    }

    private object LottoCache {
        val cache = Array(MAX_NUMBER) { LottoNumber(it + MIN_NUMBER) }

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

        fun getLottoNumbers() = LottoCache.cache.toList()
    }
}
