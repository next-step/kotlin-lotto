package lotto

class Lotto {
    val numbers: List<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().subList(0, NUMBER_COUNT)

    companion object {
        private const val FIRST_NUMBER = 1
        private const val LAST_NUMBER = 45
        private const val THREE_MATCH_PRIZE = 5_000
        private const val FOUR_MATCH_PRIZE = 50_000
        private const val FIVE_MATCH_PRIZE = 1_500_000
        private const val SIX_MATCH_PRIZE = 2_000_000_000
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000

        val prizes = listOf(0, 0, 0, THREE_MATCH_PRIZE, FOUR_MATCH_PRIZE, FIVE_MATCH_PRIZE, SIX_MATCH_PRIZE)
    }
}
