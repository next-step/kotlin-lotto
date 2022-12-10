package lotto.domain

enum class WinAmount(private val count: Int, val amount: Long) {
    FOUR(3, 5_000),
    THREE(4, 50_000),
    TWO(5, 1_500_000),
    ONE(6, 2_000_000_000);


    fun isSame(count: Int): Boolean {
        return this.count == count
    }

    companion object {
        fun find(count: Int): Long {
            return WinAmount.values().find {
                it.isSame(count)
            }?.amount ?: throw IllegalArgumentException()
        }
    }
}