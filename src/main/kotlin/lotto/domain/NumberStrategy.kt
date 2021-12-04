package lotto.domain

/**
 *
 * @author Leo
 */
fun interface NumberStrategy {

    fun numbers(): List<Int>

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        val NUMBERS = IntRange(LOTTO_START_NUMBER, LOTTO_MAX_NUMBER).toList()
    }

}
