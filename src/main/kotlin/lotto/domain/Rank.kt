package lotto.domain

enum class Rank(private val numberOfMatch: Int, private val money: Double) {
    FIRST(6, 2000000000.0),
    SECOND(5, 1500000.0),
    THIRD(4, 50000.0),
    FOURTH(3, 5000.0);

    fun getMoney() = money

    companion object {
        fun fromOrNull(matches: Int) = values().firstOrNull() { it.numberOfMatch == matches }
    }
}
