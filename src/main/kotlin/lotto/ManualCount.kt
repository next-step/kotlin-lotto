package lotto

class ManualCount(val money: Money, val count: Int) {
    init {
        require(count >= MIN) { ERROR_MESSAGE_INVALID }
        require(money.price >= count * LottoShop.LOTTO_UNIT_PRICE) {
            "수동로또 구매를 하기에는 돈이 부족합니다."
        }
    }

    constructor(money: Money, count: String?) : this(money, parseAndValidate(count))

    companion object {
        private const val MIN = 0
        private const val ERROR_MESSAGE_EMPTY = "뭐라도 입력하세요"
        private const val ERROR_MESSAGE_INVALID = "올바른 수동 구매수를 입력하세요"

        fun read(money: Money): ManualCount {
            while (true) {
                try {
                    println("수동으로 구매할 로또 수를 입력해 주세요.")
                    return ManualCount(money, readln())
                } catch (e: IllegalArgumentException) {
                    println(e.message)
                }
            }
        }

        private fun parseAndValidate(count: String?): Int {
            requireNotNull(count) { ERROR_MESSAGE_EMPTY }
            require(count.isNotBlank()) { ERROR_MESSAGE_EMPTY }
            return requireNotNull(count.toIntOrNull()) { ERROR_MESSAGE_INVALID }
        }
    }
}
