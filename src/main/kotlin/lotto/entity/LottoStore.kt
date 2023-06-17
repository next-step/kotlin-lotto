package lotto.entity

object LottoStore {
    private val lottoNumbers = (LottoNumber.MIN_LOTTO_NUMBER..LottoNumber.MAX_LOTTO_NUMBER).toList()

    fun ticketing(money: Long): List<Lotto> = (1..(money / Lotto.LOTTO_PRICE)).map { of() }

    private fun of(): Lotto =
        Lotto(
            numbers = lottoNumbers
                .shuffled()
                .take(Lotto.NUMBER_OF_LOTTO_NUMBER)
                .sorted()
                .map { LottoNumber(it) }
                .toSet()
        )
}
