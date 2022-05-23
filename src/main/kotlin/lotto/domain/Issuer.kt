package lotto.domain

object Issuer : Issuable {
    private val NUMBER_RANGE = (1..45)

    override fun issue(): Lotto =
        NUMBER_RANGE
            .shuffled()
            .take(Lotto.NUMBER_COUNT)
            .sorted()
            .let(::Lotto)
}
