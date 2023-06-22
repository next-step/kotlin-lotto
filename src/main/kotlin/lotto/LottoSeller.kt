package lotto

class LottoSeller(
    private val lottoFactory: LottoFactory,
    private val lottoPrice: Int,
) {
    fun sell(totalPurchasePrice: Int): Lottos {
        require(totalPurchasePrice >= lottoPrice) { "총 구매금액은 로또 한 장의 가격보다 커야합니다." }
        require(totalPurchasePrice % lottoPrice == 0) { "총 구매금액이 로또 구매금액으로 나누어 떨어지지 않습니다." }
        return Lottos(List(totalPurchasePrice / lottoPrice) { lottoFactory.create(lottoPrice) })
    }
}
