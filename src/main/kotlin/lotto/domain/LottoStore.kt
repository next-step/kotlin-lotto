package lotto.domain

class LottoStore(private val generator: LottoGenerator = LottoGenerator()) {

    fun sell(money: KRW): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        repeat(money.availableLottoQuantity) {
            lottos.add(generator.generate())
        }
        return lottos
    }
}
