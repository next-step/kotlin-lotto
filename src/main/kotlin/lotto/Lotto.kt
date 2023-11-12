package lotto

class Lotto() {
    fun generateCachedLottoNumbers(): List<Int> {
        return cachedLottoNumbers
    }

    private val cachedLottoNumbers: List<Int> by lazy {
        generateLottoNumbers()
    }

    private fun generateLottoNumbers(): List<Int> {
        return (MIN_NUMBER until MAX_NUMBER).toList().shuffled().take(LOTTO_COUNT).sorted()
    }

    override fun toString(): String {
        return generateCachedLottoNumbers().toString()
    }

    companion object {
        const val LOTTO_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 46

        fun validateLottoNumber(lottos: String): List<Int> {
            val result = lottos.split(",").map { it.trim().toInt() }
            if (result.size != LOTTO_COUNT || result.any { it < MIN_NUMBER || it >= MAX_NUMBER }) {
                return emptyList()
            }
            return result
        }
    }
}
