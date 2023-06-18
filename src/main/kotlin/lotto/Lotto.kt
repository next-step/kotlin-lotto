package lotto

class Lotto {
    val numbers: List<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().subList(0, NUMBER_COUNT)

    companion object {
        private const val FIRST_NUMBER = 1
        private const val LAST_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000
        const val THREE_MATCH_PRIZE = 5_000
        const val FOUR_MATCH_PRIZE = 50_000
        const val FIVE_MATCH_PRIZE = 1_500_000
        const val SIX_MATCH_PRIZE = 2_000_000_000
    }
}
