package lotto.domain

class LottoMachine(private val lottoPrice: Money, private val lottoGenerator: LottoGenerator) {

    fun sellLottos(money: Money, manualLottoGenerators: List<ManualLottoGenerator> = emptyList()): List<Lotto> {
        require(money >= lottoPrice) { "금액은 로또가격보다 크거나 같아야 합니다. money: ${money.value}, lottoPrice: ${lottoPrice.value}" }
        require(money % lottoPrice == Money.EMPTY) { "로또 구매 후 남은 돈이 있을 수 없습니다. money: ${money.value}, lottoPrice: ${lottoPrice.value}" }
        require(manualLottoGenerators.isEmpty() || money >= lottoPrice * PositiveNumber(manualLottoGenerators.size)) { "수동 로또를 구매하기에 부족한 금액입니다. money: ${money.value}, lottoPrice: ${lottoPrice.value}, manualLottoGenerators size: ${manualLottoGenerators.size}" }

        val sellableAllLottoCount = money / lottoPrice
        val manualLottoCount = manualLottoGenerators.count()
        val randomLottoCount = sellableAllLottoCount - manualLottoCount

        val manualLotto = manualLottoGenerators.map { it.generate() }
        val randomLotto = List(randomLottoCount) { lottoGenerator.generate() }

        return manualLotto + randomLotto
    }
}
