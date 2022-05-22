package lotto

object LottoIssuer : LottoIssuable {
    private val NUMBER_RANGE = (1..45)

    override fun issue(): Lotto =
        NUMBER_RANGE
            .shuffled()
            .subList(0, Lotto.NUMBER_COUNT)
            .sorted()
            .let(::Lotto)
}
