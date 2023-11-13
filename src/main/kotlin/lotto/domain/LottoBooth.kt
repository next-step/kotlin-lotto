package lotto.domain

object LottoBooth {
    const val LOTTO_PRICE = 1000

    fun publishLottos(strategy: LottoBuyStrategy): LottoList {
        return ManualLottoCreator.createLottoList(*strategy.manualLottoList.toTypedArray()) + AutoLottoCreator.createLottoList(strategy.autoCount)
    }
}
