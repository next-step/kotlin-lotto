package lotto.domain

class LottoStore(private val generator: LottoGenerator = LottoGenerator()) {

    fun sell(money: KRW): List<Lotto> {
        val lottos = buildList {
            repeat(money.availableLottoQuantity) {
                add(generator.generate())
            }
        }
        return lottos
    }
}
