package lotto.domain

object LottoGenerator {
    fun generate(): Lotto {
        return Lotto(
            LOTTO_NUMBER_RANGE
                .shuffled()
                .take(LOTTO_SIZE)
                .map(LottoNumber::of)
                .toSet()
        )
    }

    private val LOTTO_NUMBER_RANGE = (1..45)

    private const val LOTTO_SIZE = 6
}
