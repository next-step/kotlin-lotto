package lotto

class LottoResult {
    var prize: Prize = Prize.NONE
        private set

    fun check(machRuleFunc: () -> Set<Int>): LottoResult {
        prize = Prize.getOrNull(
            machCount = machRuleFunc().size
        ) ?: Prize.NONE

        return this
    }

    enum class Prize(val machCount: Int, val price: Int) {
        NONE(0, 0),
        FIRST(1, 0),
        SECOND(2, 0),
        THIRD(3, 5_000),
        FORTH(4, 50_000),
        FIFTH(5, 1_500_000),
        SIXTH(6, 2_000_000_000);

        companion object {
            fun getOrNull(machCount: Int): Prize? =
                values().firstOrNull() { it.machCount == machCount }
        }
    }
}
