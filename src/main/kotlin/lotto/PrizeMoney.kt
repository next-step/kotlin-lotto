package lotto

enum class PrizeMoney(_equalsCount: Int, _money: Int) {

    SIX(6, 2000000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000);

    var equalsCount: Int = _equalsCount
        private set
    var money: Int = _money
        private set

    fun countToPrizeMoney(prizeCount: Int): Int = prizeCount * money

    companion object {
        fun generate(equalsCount: Int): PrizeMoney {
            return enumValues<PrizeMoney>().first {
                it.equalsCount == equalsCount
            }
        }
    }
}
