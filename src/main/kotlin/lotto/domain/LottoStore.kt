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

    fun sell(money: KRW, manual: List<String>): List<Lotto> {
        require(money.availableLottoQuantity >= manual.size) {
            "구매할 로또의 수 이상의 금액을 가지고 있으셔야합니다."
        }

        return manual.map {
            Lotto.manual(it)
        }.toList()
    }
}
