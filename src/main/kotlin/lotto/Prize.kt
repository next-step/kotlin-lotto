package lotto

enum class Prize(val money: Int) {
    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000),
    NONE(0),
    ;

    companion object {
        fun from(count: Int): Prize {
            return when (count) {
                6 -> FIRST
                5 -> SECOND
                4 -> THIRD
                3 -> FOURTH
                else -> NONE
            }
        }
    }

}
