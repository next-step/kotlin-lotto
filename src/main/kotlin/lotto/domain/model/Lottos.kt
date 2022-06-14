package lotto.domain.model

@JvmInline
value class Lottos private constructor(val value: List<Lotto>) {
    operator fun plus(other: Lottos): Lottos {
        return Lottos(value + other.value)
    }

    companion object {
        fun from(lottos: List<Lotto>): Lottos {
            return Lottos(lottos)
        }

        fun of(purchaseCount: PurchaseCount, lottoFactory: LottoFactory): Lottos {
            return Lottos(
                List(purchaseCount.value) {
                    lottoFactory.create()
                }
            )
        }

        fun empty(): Lottos {
            return Lottos(listOf())
        }
    }
}
