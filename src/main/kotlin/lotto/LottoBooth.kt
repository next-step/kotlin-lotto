package lotto

object LottoBooth {
    private const val LOTTO_PRICE = 1000

    fun publishLottos(money: Money, strategy: CreateStrategy = RandomStrategy()): LottoList {
        val lottoCount = money.amount / LOTTO_PRICE
        return LottoList(List(lottoCount) { Lotto(strategy) })
    }
}
