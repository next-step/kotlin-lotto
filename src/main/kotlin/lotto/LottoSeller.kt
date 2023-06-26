package lotto

class LottoSeller(
    private val lottoFactory: AutoLottoFactory,
    private val lottoPrice: Int,
) {
    fun sell(order: LottoPurchaseOrder): Lottos {
        val totalPurchasePrice = order.totalPurchasePrice
        require(totalPurchasePrice >= (order.manualLottoNumbers.size * lottoPrice)) { "수동로또의 총 구매금액이 전체 금액보다 클 수 없습니다" }
        require(totalPurchasePrice >= lottoPrice) { "총 구매금액은 로또 한 장의 가격보다 커야합니다." }
        require(totalPurchasePrice % lottoPrice == 0) { "총 구매금액이 로또 구매금액으로 나누어 떨어지지 않습니다." }

        val numberOfAutoLottos = (totalPurchasePrice - lottoPrice * order.manualLottoNumbers.size) / lottoPrice
        val autoLottos = List(numberOfAutoLottos) { lottoFactory.create(lottoPrice) }
        val manualLottos = order.manualLottoNumbers.map { Lotto(it, lottoPrice, LottoType.MANUAL) }
        return Lottos(autoLottos.plus(manualLottos))
    }
}
