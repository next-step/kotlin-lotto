package lotto.domain

class LottoBuyerCount(money: Int, val manualLottoCount: Int) {
    val autoLottoCount: Int

    init {
        require((money / LOTTO_PRICE) - manualLottoCount >= 0) { EXCEED_LOTTO_MANUAL_COUNT }
        autoLottoCount = (money / LOTTO_PRICE) - manualLottoCount
    }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val EXCEED_LOTTO_MANUAL_COUNT = "수동으로 구매 가능한 로또 수를 초과하였습니다."
    }
}
