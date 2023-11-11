package lotto

class Lotto(originNumbers: List<Int> = listOf()) {
    val numbers: List<Int> = originNumbers.takeIf { it.isNotEmpty() } ?: generateLottoNumbers()
    fun validateLottoNumber(lottos: String): List<Int> {
        val result = lottos.split(",").map { it.trim().toInt() }
        if (result.size != LOTTO_COUNT || result.any { it < MIN_NUMBER || it >= MAX_NUMBER }) {
            return emptyList()
        }
        return result
    }

    private fun generateLottoNumbers(): List<Int> {
        val numberRange = (MIN_NUMBER..MAX_NUMBER).toList()
        return numberRange.shuffled().take(LOTTO_COUNT).sorted()
    }

    companion object {
        const val LOTTO_COUNT = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 46
    }
}
