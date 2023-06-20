package domain

class WinningFinder(
    private val winningNums: Set<Int>,
    private val bonusBall: Int,
) {

    fun getPrizeByMatched(lottery: Lottery): Prize? {
        val matchedNumberCount = lottery.lotteryNumbers.intersect(winningNums).size

        return when {
            matchedNumberCount == Prize.FIRST_PLACE.matches -> Prize.FIRST_PLACE
            matchedNumberCount == Prize.SECOND_PLACE.matches && lottery.lotteryNumbers.contains(bonusBall) -> Prize.SECOND_PLACE
            matchedNumberCount == Prize.THIRD_PLACE.matches -> Prize.THIRD_PLACE
            matchedNumberCount == Prize.FOURTH_PLACE.matches -> Prize.FOURTH_PLACE
            matchedNumberCount == Prize.FIFTH_PLACE.matches -> Prize.FIFTH_PLACE
            else -> null
        }
    }
}
