package lotto.domain

class LottoMachine(private val lottoPrice: Money, private val lottoGenerator: LottoGenerator) {

    fun sellLottos(money: Money, manualLottoGenerators: List<ManualLottoGenerator> = emptyList()): List<Lotto> {
        require(manualLottoGenerators.isEmpty() || money >= lottoPrice * PositiveNumber(manualLottoGenerators.size)) { "수동 로또를 구매하기에 부족한 금액입니다. money: ${money.value}, lottoPrice: ${lottoPrice.value}, manualLottoGenerators size: ${manualLottoGenerators.size}" }

        val sellableAllLottoCount = money.sellableLottoCount(lottoPrice)

        val manualLottoCount = manualLottoGenerators.count()
        val randomLottoCount = sellableAllLottoCount - manualLottoCount

        val manualLotto = manualLottoGenerators.map { it.generate() }
        val randomLotto = List(randomLottoCount) { lottoGenerator.generate() }

        return manualLotto + randomLotto
    }
}
