package lotto.model

enum class LottoPrize(val prize: Int, val count: Int) {
    FOURTH(5_000, 3),
    THIRD(50_000, 4),
    SECOND(1_500_000, 5),
    FIRST(2_000_000_000, 6);
//    NONE(0, 0);

    companion object {
        fun of(count: Int): LottoPrize? {
            return values().find { it.count == count }
        }
    }
}
