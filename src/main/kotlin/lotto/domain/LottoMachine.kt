package lotto.domain

class LottoMachine(val buyPrice: Long = 0L) {

    fun createManualLotto(inputString: List<String>): List<ManualLotto> {
        return inputString.map { ManualLotto().initLottoNumbers(it) }
    }

    fun calculateAutoLottoCount(manualLottoCount: Int): Int {
        return (calculateAutoLottoBuyPrice(manualLottoCount) / LOTTO_PRICE_PER_ONE).toInt()
    }

    fun calculateAutoLottoBuyPrice(manualLottoCount: Int): Long {
        val autoLottoBuyPrice = buyPrice - (manualLottoCount * LOTTO_PRICE_PER_ONE)
        require(autoLottoBuyPrice >= 0) { "로또 구매 금액이 부족합니다." }
        return autoLottoBuyPrice
    }

    fun createAutoLotto(count: Int): List<AutoLotto> = List(size = count) {
        AutoLotto(buyPrice)
    }

    companion object {
        const val LOTTO_PRICE_PER_ONE = 1000L
    }
}
