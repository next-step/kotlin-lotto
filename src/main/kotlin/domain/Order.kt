package domain

data class Order(
    private val money: Int,
    val manualSize: Int,
    val manualLotteries: List<Lottery>
) {

    init {
        require(money / 1000 >= manualSize) { "${manualSize}수동 구매 수량은 ${money / 1000}보다 작아야 합니다." }
    }

    fun autoSize(): Int {
        return money / 1000 - manualSize
    }
}
