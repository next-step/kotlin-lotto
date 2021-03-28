package lotto.domain

class LottoMachine(private val lottoPrice: Money, private val randomLottoGenerator: LottoGenerator) {

    fun sellLottos(money: Money, manualLottoGenerators: List<LottoGenerator> = emptyList()): List<Lotto> {
        require(manualLottoGenerators.isEmpty() || money >= lottoPrice * PositiveNumber(manualLottoGenerators.size)) { "수동 로또를 구매하기에 부족한 금액입니다. money: ${money.value}, lottoPrice: ${lottoPrice.value}, manualLottoGenerators size: ${manualLottoGenerators.size}" }

        val sellableAllLottoCount = money.sellableLottoCount(lottoPrice)

        val lottoCount = manualLottoGenerators.count()
        val defaultLottoCount = sellableAllLottoCount - lottoCount

        val manualLottos = manualLottoGenerators.map { it.generate() }
        val randomLottos = List(defaultLottoCount) { randomLottoGenerator.generate() }

        return manualLottos + randomLottos
    }
}
