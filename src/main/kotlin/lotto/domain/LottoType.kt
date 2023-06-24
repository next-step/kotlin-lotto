package lotto.domain

enum class LottoType {
    MANUAL {
        override fun generate(lottoQuantity: LottoQuantity, lottoNumbers: List<LottoNumbers>): Lottos {
            return Lottos.from(lottoNumbers.map { Lotto(it) })
        }
    },
    AUTO {
        override fun generate(lottoQuantity: LottoQuantity, lottoNumbers: List<LottoNumbers>): Lottos {
            return Lottos.random(lottoQuantity)
        }
    },
    ;

    abstract fun generate(
        lottoQuantity: LottoQuantity,
        lottoNumbers: List<LottoNumbers> = emptyList(),
    ): Lottos
}
