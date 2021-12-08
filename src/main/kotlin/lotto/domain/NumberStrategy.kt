package lotto.domain

/**
 *
 * @author Leo
 */
interface NumberStrategy {

    fun numbers(): List<LottoNumber>

    fun find(target: Int): LottoNumber

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
        val NUMBERS = IntRange(LOTTO_START_NUMBER, LOTTO_MAX_NUMBER).toList()
    }

}
