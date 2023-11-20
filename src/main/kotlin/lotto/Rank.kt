package lotto

enum class Rank(val count: Int, private val winningMoney: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0)
    ;

    fun getWinningMoney(size: Int): Int {
        return winningMoney * size
    }

    companion object {
        fun valueOf(count: Int, matchBonus: Boolean): Rank? {
            return values().find { if (count == 5 && matchBonus) it == SECOND else it.count == count }
        }
    }
}