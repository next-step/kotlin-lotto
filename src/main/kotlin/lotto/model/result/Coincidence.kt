package lotto.model.result

enum class Coincidence(val coincidenceCount: Int, val prizeMoney: Int, val hasBonusNum: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(prizeMoney = 0);

    constructor(prizeMoney: Int)

    companion object {
        private const val TWO = 2

        fun match(matchedCountForOneLotto: Int, hasBonusNum: Boolean): Coincidence {
            return findMatchedResult(matchedCountForOneLotto, hasBonusNum) ?: MISS
        }

        private fun findMatchedResult(matchedCountForOneLotto: Int, hasBonusNum: Boolean): Coincidence? {
            val matchedResult = values()
                .filter { it.coincidenceCount == matchedCountForOneLotto }

            if (matchedResult.size == TWO) {
                return matchedResult.firstOrNull { it.hasBonusNum == hasBonusNum }
            }

            return matchedResult.firstOrNull()
        }
    }
}
