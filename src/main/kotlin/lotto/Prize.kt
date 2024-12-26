package lotto

enum class Prize(val money: Int, val count: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    NONE(0, 0),
    ;

    companion object {
        fun from(count: Int): Prize {
            return entries.find { it.count == count } ?: NONE
        }
    }

}
