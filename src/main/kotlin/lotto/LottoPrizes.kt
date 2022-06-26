package lotto

@JvmInline
value class LottoPrizes(private val values: List<LottoPrize>) {
    fun firstPlaceCount(): Int {
        return this.values.count { it == LottoPrize.FIRST_PLACE }
    }

    fun secondPlaceCount(): Int {
        return this.values.count { it == LottoPrize.SECOND_PLACE }
    }

    fun thirdPlaceCount(): Int {
        return this.values.count { it == LottoPrize.THIRD_PLACE }
    }

    fun forthPlaceCount(): Int {
        return this.values.count { it == LottoPrize.FORTH_PLACE }
    }

    fun fifthPlaceCount(): Int {
        return this.values.count { it == LottoPrize.FIFTH_PLACE }
    }

    fun totalPrize(): Int {
        return this.values.sumOf { it.reward }
    }
}
