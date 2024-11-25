package lotto.domain

object LottoGenerator {
    private const val LOTTO_MIN_NUMBER = 1
    private const val LOTTO_MAX_NUMBER = 45
    private const val LOTTO_NUMBERS_COUNT = 6

    fun generateTicket() : List<Int> {
        return (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled().take(LOTTO_NUMBERS_COUNT).sorted()
    }
}
