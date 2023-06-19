package lotto.domain.model

class Lotto {
    val numbers: List<Int> = (FIRST_NUMBER..LAST_NUMBER).shuffled().subList(0, NUMBER_COUNT)

    enum class Prize(val matches: Int, val reward: Int) {
        NOTHING(0, 0),
        THREE_MATCH(3, 5_000),
        FOUR_MATCH(4, 50_000),
        FIVE_MATCH(5, 1_500_000),
        SIX_MATCH(6, 2_000_000_000)
    }

    companion object {
        private const val FIRST_NUMBER = 1
        private const val LAST_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000

        val prizes = listOf(
            Prize.NOTHING,
            Prize.NOTHING,
            Prize.NOTHING,
            Prize.THREE_MATCH,
            Prize.FOUR_MATCH,
            Prize.FIVE_MATCH,
            Prize.SIX_MATCH
        )
    }
}
