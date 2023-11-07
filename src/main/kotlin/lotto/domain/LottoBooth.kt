package lotto.domain

object LottoBooth {
    private const val LOTTO_PRICE = 1000

    fun publishLottos(money: Money): LottoList {
        val lottoCount = money.amount / LOTTO_PRICE
        val lottoCreator = AutoLottoCreator()
        return LottoList(List(lottoCount) { lottoCreator.createLotto() })
    }
}
