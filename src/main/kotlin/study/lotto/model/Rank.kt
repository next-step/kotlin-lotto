package study.lotto.model

/**
 * @author 이상준
 */
enum class Rank(val prize: Int, val amount: Int) {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun findPrize(prize: Int, matchBonus: Boolean = false): Rank {
            return entries.find { it.prize == prize }?.let {
                if (it == THIRD && matchBonus) {
                    SECOND
                } else {
                    it
                }
            } ?: MISS
        }
    }
}
