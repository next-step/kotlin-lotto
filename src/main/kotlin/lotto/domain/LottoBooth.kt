package lotto.domain

object LottoBooth {
    const val LOTTO_PRICE = 1000

    fun publishLottos(strategy: LottoBuyStrategy): LottoList {
        return ManualLottoCreator(*strategy.manualLottoList.toTypedArray()).createLottoList() + AutoLottoCreator(
            strategy.autoCount
        ).createLottoList()
    }
}
