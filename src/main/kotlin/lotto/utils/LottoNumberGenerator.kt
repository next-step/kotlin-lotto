package lotto.utils

object LottoNumberGenerator {
    private const val LOTTO_NUMBER_START_BOUND = 1
    private const val LOTTO_NUMBER_END_BOUND = 43

    fun auto(): Set<Int> {
        return (LOTTO_NUMBER_START_BOUND..LOTTO_NUMBER_END_BOUND).toList()
            .shuffled()
            .take(6)
            .sorted()
            .toSet()
    }
}
