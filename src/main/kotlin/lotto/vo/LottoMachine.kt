package lotto.vo

class LottoMachine(val buyPrice: Long = 0L) {

    fun createManualLotto(inputString: List<String>): List<ManualLotto> {
        return inputString.map { ManualLotto.initLottoNumbers(it) }
    }

    fun calculateAutoLottoCount(manualLottoCount: Long): Long {
        return calculateAutoLottoBuyPrice(manualLottoCount) / LOTTO_PRICE_PER_ONE
    }

    fun calculateAutoLottoBuyPrice(manualLottoCount: Long): Long {
        val autoLottoBuyPrice = buyPrice - (manualLottoCount * LOTTO_PRICE_PER_ONE)
        require(autoLottoBuyPrice >= 0) { "로또 구매 금액이 부족합니다." }
        return autoLottoBuyPrice
    }

    fun createAutoLotto(count: Long): List<AutoLotto> {
        val autoLottoList = mutableListOf<AutoLotto>()
        for (i in 1..count) {
            val autoLotto = AutoLotto(buyPrice)
            autoLottoList.add(autoLotto)
        }
        return autoLottoList
    }

    companion object {
        private const val LOTTO_PRICE_PER_ONE = 1000L
    }
}
