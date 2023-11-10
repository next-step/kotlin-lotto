package lotto.domain

object LottoBooth {
    const val LOTTO_PRICE = 1000

    fun publishLottos(strategy: LottoBuyStrategy): LottoList {
        return strategy.manualLottoList + List(strategy.autoCount) { AutoLottoCreator().createLotto() }
    }
}
