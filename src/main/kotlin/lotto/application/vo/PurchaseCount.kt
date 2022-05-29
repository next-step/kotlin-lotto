package lotto.application.vo

@JvmInline
value class PurchaseCount(
    val count: Int
) {
    init {
        require(count >= 0) { "구매 개수는 음수가 될수 없습니다." }
    }
}
