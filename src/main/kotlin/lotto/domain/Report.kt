package lotto.domain

import kotlin.math.roundToInt

data class Report(
    private val notWin: NotWin = NotWin(),
    val fourthWin: FourthWin = FourthWin(),
    val thirdWin: ThirdWin = ThirdWin(),
    val secondWin: SecondWin = SecondWin(),
    val firstWin: FirstWin = FirstWin()
) {

    fun increaseNotWin() {
        notWin.increase()
    }

    fun increaseFourthWin() {
        fourthWin.increase()
    }

    fun increaseThirdWin() {
        thirdWin.increase()
    }

    fun increaseSecondWin() {
        secondWin.increase()
    }

    fun increaseFirstWin() {
        firstWin.increase()
    }

    fun getRateOfReturn(): Double {
        return (calculatePrize() / calculateLottoBundlePrice() * 100.0).roundToInt() / 100.0
    }

    private fun calculatePrize(): Int {
        return fourthWin.calculatePrize() + thirdWin.calculatePrize() + secondWin.calculatePrize() + firstWin.calculatePrize()
    }

    private fun calculateLottoBundlePrice(): Int {
        return (notWin.count + fourthWin.count + thirdWin.count + secondWin.count + firstWin.count) * 1000
    }
}
