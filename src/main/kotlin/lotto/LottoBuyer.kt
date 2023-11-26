package lotto

class LottoBuyer(
    private val money: Int
) {

    fun buyLottoFrom(lottoStore: LottoStore): List<Lotto> {
        require(money >= Lotto.PRICE) { "돈이 부족합니다." }
        return lottoStore.sell(money)
    }
}