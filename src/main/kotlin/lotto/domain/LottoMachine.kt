package lotto.domain

class LottoMachine(private val lottoPrice: Money, private val randomLottoGenerator: LottoGenerator) {

    fun sellLottos(money: Money, manualLottoGenerators: List<LottoGenerator> = emptyList()): List<Lotto> {
        val sellableAllLottoCount = money.sellableLottoCount(lottoPrice, manualLottoGenerators.count())

        val manualLottoCount = manualLottoGenerators.count()
        val randomLottoCount = sellableAllLottoCount - manualLottoCount

        val manualLottos = manualLottoGenerators.map { it.generate() }
        val randomLottos = List(randomLottoCount) { randomLottoGenerator.generate() }

        return manualLottos + randomLottos
    }
}
