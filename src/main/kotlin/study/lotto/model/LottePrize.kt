package study.lotto.model

/**
 * @author 이상준
 */
enum class LottePrize(val prize: Int, val amount: Int) {
    FOURTH(3, 50000),
    THIRD(4, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    ;

    companion object {
        fun findPrize(prize: Int): LottePrize? {
            return entries.find { it.prize == prize }
        }
    }
}
