package lotto.domain.model

class RangeLottoFactory(
    private val lottoRange: IntRange = LottoNumber.LOTTO_NUMBER_RANGE
) : LottoFactory {
    override fun create(): Lotto {
        val numbers = lottoRange
            .asSequence()
            .shuffled()
            .take(Lotto.LOTTO_NUMBER_COUNT)
            .map { number ->
                LottoNumber[number]
            }.toSet()

        return Lotto.from(numbers)!!
    }
}
