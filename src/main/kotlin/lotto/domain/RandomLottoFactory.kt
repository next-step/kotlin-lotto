package lotto.domain

object RandomLottoFactory {

    private val LOTTO_NUMBERS = (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE)
        .map { LottoNumber(it) }
        .toList()

    fun generate(): Lotto {
        val numbers = LOTTO_NUMBERS
            .shuffled()
            .take(Lotto.NUMBERS_SIZE)
        return Lotto(numbers)
    }
}
