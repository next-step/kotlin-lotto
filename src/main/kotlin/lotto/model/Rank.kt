package lotto.model

enum class Rank(val reward: Int, val count: Int) {
    //    MISS(0, 0),
    FIFTH(5_000, 3),
    FOURTH(50_000, 4),
    THIRD(1_500_000, 5),
    SECOND(30_000_000, 5),
    FIRST(2_000_000_000, 6);


    companion object {
        fun of(count: Int, isBonus: Boolean): Rank? {
            return if (count == SECOND.count && isBonus) {
                SECOND
            } else {
                values().find { it.count == count }
            }
        }
    }
}
