package lotto

enum class PrizeMoney(private val equalsCount: Int, private val money: Int) {

    SIX(6, 2000000000),
    FIVE(5, 1500000),
    FOUR(4, 50000),
    THREE(3, 5000);

    fun getPrizeMoney(): Int = money
    fun getEqualsCount(): Int = equalsCount

    companion object {
        fun generate(equalsCount: Int): PrizeMoney {
            return enumValues<PrizeMoney>().first {
                it.equalsCount == equalsCount
            }
        }
    }
}
