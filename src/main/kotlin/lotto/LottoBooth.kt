package lotto

object LottoBooth {
    private const val LOTTO_PRICE = 1000

    fun publishLottos(money: Int, strategy: CreateStrategy = RandomStrategy()): LottoList {
        val lottoNumber = money / LOTTO_PRICE
        return LottoList(List(lottoNumber) { Lotto(LottoNumbers(strategy)) })
    }
}
