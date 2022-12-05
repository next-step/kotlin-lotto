package lotto

enum class Rank(val count: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOUR(4, 50_000),
    FIVE(3, 5_000),
    NONE(0, 0);

    companion object {
        fun findByFirst(contains: Int): Rank {
            for (value in values()) {
                if (contains == value.count) {
                    return value
                }
            }
            return NONE
        }
    }
}