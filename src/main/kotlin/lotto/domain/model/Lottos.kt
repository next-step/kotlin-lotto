package lotto.domain.model

@JvmInline
value class Lottos(val value: List<Lotto>) {
    companion object {
        fun of(purchaseCount: PurchaseCount, lottoFactory: LottoFactory): Lottos {
            return Lottos(
                List(purchaseCount.value) {
                    lottoFactory.create()
                }
            )
        }
    }
}
