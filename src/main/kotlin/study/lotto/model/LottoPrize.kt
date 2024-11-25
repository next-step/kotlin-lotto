package study.lotto.model

/**
 * @author 이상준
 */
enum class LottoPrize(val prize: Int, val amount: Int) {
    FOURTH(3, 50_000),
    THIRD(4, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    ;

    companion object {
        fun findPrize(prize: Int): LottoPrize? {
            return entries.find { it.prize == prize }
        }
    }
}
