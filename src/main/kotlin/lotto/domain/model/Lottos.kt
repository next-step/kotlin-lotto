package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    companion object {
        fun of(purchaseCount: Int, lottoFactory: LottoFactory): Lottos {
            return Lottos(
                List(purchaseCount) {
                    lottoFactory.create()
                }
            )
        }
    }
}
