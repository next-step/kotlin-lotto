package lotto.domain

class LottoMachine(private val lottoPrice: Int, private val lottoGenerator: LottoGenerator) {

    init {
        require(lottoPrice > 0) { "로또금액은 0보다 커야합니다" }
    }

    fun sellLottos(money: Int, manualLottoGenerators: List<ManualLottoGenerator> = emptyList()): List<Lotto> {
        require(money >= lottoPrice) { "금액은 로또가격보다 크거나 같아야 합니다. money: $money, lottoPrice: $lottoPrice" }
        require(money % lottoPrice == 0) { "로또 구매 후 남은 돈이 있을 수 없습니다. money: $money, lottoPrice: $lottoPrice" }
        require(money >= lottoPrice * manualLottoGenerators.size) { "수동 로또를 구매하기에 부족한 금액입니다. money: $money, lottoPrice: $lottoPrice, manualLottoGenerators size: ${manualLottoGenerators.size}" }

        val sellableAllLottoCount = money / lottoPrice
        val manualLottoCount = manualLottoGenerators.count()
        val randomLottoCount = sellableAllLottoCount - manualLottoCount

        val manualLotto = manualLottoGenerators.map { it.generate() }
        val randomLotto = List(randomLottoCount) { lottoGenerator.generate() }

        return manualLotto + randomLotto
    }
}
