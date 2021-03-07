package lotto

class LottoMachine(private val lottoPrice: Int, private val lottoGenerator: LottoGenerator) {

    init {
        require(lottoPrice > 0) { "로또금액은 0보다 커야합니다" }
    }

    fun sellLottos(money: Int): List<Lotto> {
        require( money >= lottoPrice ) { "금액은 로또가격보다 크거나 같아야 합니다. money: $money, lottoPrice: $lottoPrice" }
        require(money % lottoPrice == 0) { "로또 구매 후 남은 돈이 있을 수 없습니다. money: $money, lottoPrice: $lottoPrice" }
        
        val sellableLottoCount = money / lottoPrice
        return (1..sellableLottoCount).map { lottoGenerator.generate() }
    }
}
