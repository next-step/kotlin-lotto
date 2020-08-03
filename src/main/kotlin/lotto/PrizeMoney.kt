package lotto

enum class PrizeMoney(private val equalsCount: Int) {
    SIX(6) {
        private val prizeMoney = 2000000000
        override fun getPrizeMoney(): Int = prizeMoney
    },
    FIVE(5) {
        private val prizeMoney = 1500000
        override fun getPrizeMoney(): Int = prizeMoney
    },
    FOUR(5) {
        private val prizeMoney = 50000
        override fun getPrizeMoney(): Int = prizeMoney
    },
    THREE(4) {
        private val prizeMoney = 5000
        override fun getPrizeMoney(): Int = prizeMoney
    },
    OTHER(0) {
        private val prizeMoney = 0
        override fun getPrizeMoney(): Int = prizeMoney
    };

    abstract fun getPrizeMoney(): Int
    fun getProfit(prizeCount: Int): Int = getPrizeMoney() * prizeCount

    companion object {
        fun generate(equalsCount: Int): PrizeMoney {
            return enumValues<PrizeMoney>().find {
                it.equalsCount == equalsCount
            } ?: OTHER
        }
    }
}
