package lotto.domain

class ManualCount(val money: Money, val count: Int) {
    init {
        require(count >= MIN) { ERROR_MESSAGE_INVALID }
        require(money.price >= count * LottoShop.LOTTO_UNIT_PRICE) {
            "수동로또 구매를 하기에는 돈이 부족합니다."
        }
    }

    companion object {
        private const val MIN = 0
        private const val ERROR_MESSAGE_INVALID = "올바른 수동 구매수를 입력하세요"
    }
}
