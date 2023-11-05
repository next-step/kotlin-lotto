package lotto

object LottoBooth {
    private const val LOTTO_PRICE = 1000

    fun publishLottos(money: Int, strategy: CreateStrategy = RandomStrategy()): LottoList {
        val lottoCount = money / LOTTO_PRICE
        return LottoList(List(lottoCount) { Lotto(LottoNumbers(strategy)) })
    }
}
