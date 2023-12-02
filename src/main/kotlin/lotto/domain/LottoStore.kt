package lotto.domain

class LottoStore {
    private val lottoGenerator = LottoGenerator()

    fun buyLotto(lottoGenerateStrategy: LottoGenerateStrategy): Lotto {
        return lottoGenerator.publish(lottoGenerateStrategy)
    }

    fun buyLottos(money: Int, lottoGenerateStrategy: LottoGenerateStrategy): Lottos {
        val lottoCount = money / LOTTO_PRICE
        val lottos = List(lottoCount) {
            lottoGenerator.publish(lottoGenerateStrategy)
        }

        return Lottos(lottos)
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}
