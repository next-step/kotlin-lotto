package lotto

class Money(_money: Int) {
    var money: Int = _money
        private set

    fun divide(rate: Int): Int = money / rate
    fun divideRemain(rate: Int): Int = money % rate

    fun save(_money: Int) {
        money += _money
    }

    fun rate(rate: Int): Double = money.toDouble() / rate.toDouble()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (money != other.money) return false

        return true
    }

    override fun hashCode(): Int {
        return money
    }
}
