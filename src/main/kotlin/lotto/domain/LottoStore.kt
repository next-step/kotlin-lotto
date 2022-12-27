package lotto.domain

class LottoStore(private val generator: LottoGenerator = LottoGenerator()) {

    fun sellAutoLottos(money: KRW, lottoBundle: LottoBundle): KRW {
        val lottos = buildList {
            repeat(money.availableLottoQuantity) {
                add(generator.generate())
            }
        }
        lottoBundle.addAll(lottos)
        return KRW(money.money - money.availableLottoQuantity * 1000)
    }

    fun sellManualLottos(money: KRW, manual: List<String>, lottoBundle: LottoBundle): KRW {
        require(money.availableLottoQuantity >= manual.size) {
            "구매할 로또의 수 이상의 금액을 가지고 있으셔야합니다."
        }

        val lottos = manual.map {
            Lotto.manual(it)
        }.toList()
        lottoBundle.addAll(lottos)
        return KRW(money.money - (manual.size * 1000))
    }
}
