package lotto

class Money(_money: Int) {
    private var money: Int = _money
        private set

    fun divide(rate: Int): Int = money / rate
    fun devideRemain(rate: Int): Int = money % rate
}
