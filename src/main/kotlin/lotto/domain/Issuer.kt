package lotto.domain

object Issuer : Issuable {
    private val NUMBER_RANGE = (LottoNumber.MIN_VALUE..LottoNumber.MAX_VALUE)

    override fun issue(): Lotto =
        NUMBER_RANGE
            .shuffled()
            .take(Lotto.NUMBER_COUNT)
            .sorted()
            .let(::Lotto)
}
