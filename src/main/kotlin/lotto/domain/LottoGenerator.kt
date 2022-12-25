package lotto.domain

object LottoGenerator {
    fun generate(): Lotto {
        return Lotto(
            Policy.LOTTO_NUMBER_RANGE
                .shuffled()
                .take(Policy.LOTTO_SIZE)
                .map(LottoNumber::of)
                .toSet()
        )
    }
}
