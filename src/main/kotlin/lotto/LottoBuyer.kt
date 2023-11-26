package lotto

class LottoBuyer(
    private val money: Int
) {

    fun buyLottoFrom(lottoStore: LottoStore): List<Lotto> {
        return lottoStore.sell(money)
    }
}