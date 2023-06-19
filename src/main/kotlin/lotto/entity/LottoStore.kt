package lotto.entity

object LottoStore {

    fun ticketing(money: Long): List<Lotto> = (1..(money / Lotto.LOTTO_PRICE)).map { of() }

    private fun of(): Lotto =
        Lotto(
            numbers = LottoNumber.LOTTO_NUMBERS
                .shuffled()
                .take(Lotto.NUMBER_OF_LOTTO_NUMBER)
                .sorted()
                .map { LottoNumber(it) }
                .toSet(),
        )
}
