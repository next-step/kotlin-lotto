package lotto.domain

object LottoGenerator {
    private val LOTTO_NUMBER_RANGE = 1..45
    private const val LOTTO_NUMBER_SIZE = 6

    fun generate(): Lotto {
        return Lotto(
            LOTTO_NUMBER_RANGE
                .shuffled()
                .take(LOTTO_NUMBER_SIZE)
                .map(LottoNumber::of)
                .toSet()
        )
    }
}
