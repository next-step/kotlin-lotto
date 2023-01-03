package lotto.domain

object LottoGenerator {
    fun generate(): Lotto {
        return Lotto(
            LottoNumber.LOTTO_NUMBER_RANGE
                .shuffled()
                .take(Lotto.LOTTO_SIZE)
                .map(LottoNumber::of)
                .toSet()
        )
    }
}
