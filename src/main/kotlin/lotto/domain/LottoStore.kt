package lotto.domain

class LottoStore {
    private val lottoGenerator = LottoGenerator()

    fun buyLotto(lottoNumbersGenerateStrategy: LottoNumbersGenerateStrategy): Lotto {
        return lottoGenerator.publish(lottoNumbersGenerateStrategy)
    }

    fun buyLottos(money: Int, lottoNumbersGenerateStrategy: LottoNumbersGenerateStrategy): Lottos {
        val lottoCount = money / LOTTO_PRICE
        val lottos = List(lottoCount) {
            lottoGenerator.publish(lottoNumbersGenerateStrategy)
        }

        return Lottos(lottos)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
