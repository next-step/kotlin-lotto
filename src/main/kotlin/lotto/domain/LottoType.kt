package lotto.domain

enum class LottoType {
    MANUAL {
        override fun generate(lottoQuantity: LottoQuantity, lottoNumbers: List<LottoNumbers>): Lottos {
            return Lottos.from(lottoNumbers.map { generate(it) })
        }

        override fun generate(lottoNumbers: LottoNumbers): Lotto {
            return Lotto(lottoNumbers, MANUAL)
        }
    },
    AUTO {
        override fun generate(lottoQuantity: LottoQuantity, lottoNumbers: List<LottoNumbers>): Lottos {
            return Lottos(
                List(lottoQuantity.value) { generate() },
            )
        }

        override fun generate(lottoNumbers: LottoNumbers): Lotto {
            return Lotto(LottoNumbers.random(), AUTO)
        }
    },
    ;

    abstract fun generate(
        lottoQuantity: LottoQuantity,
        lottoNumbers: List<LottoNumbers> = emptyList(),
    ): Lottos

    abstract fun generate(
        lottoNumbers: LottoNumbers = LottoNumbers.random(),
    ): Lotto
}
