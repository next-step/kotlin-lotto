package autolotto.enums.prize

enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    THREE(3, 5000) {
        override fun calculatePrize(count: Int): Int {
            return count * prizeMoney
        }
    },
    FOUR(4, 50000) {
        override fun calculatePrize(count: Int): Int {
            return (count * prizeMoney) + 1000 // 예: 추가 보너스 계산
        }
    },
    FIVE(5, 100000) {
        override fun calculatePrize(count: Int): Int {
            return count * prizeMoney / 2 // 예: 50% 지급
        }
    },
    SIX(6, 1000000) {
        override fun calculatePrize(count: Int): Int {
            return count * prizeMoney
        }
    };


    abstract fun calculatePrize(count: Int): Int

    companion object {
        fun fromMatchCount(matchCount: Int): Prize? {
            return entries.find { it.matchCount == matchCount }
        }
    }
}
