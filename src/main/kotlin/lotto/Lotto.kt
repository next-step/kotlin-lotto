package lotto

class Lotto(private val numbers: Set<Int>) {

    val lottoNumber get() = numbers

    init {
        require(numbers.size == 6) {
            "로또 숫자는 6개 입니다."
        }
    }

    fun getPrizeWithBonus(winningNumber: List<Int>, bonusNumber: Int): Rank {
        val counts = this.numbers.count { number -> winningNumber.contains(number) }

        val bonusCheck = this.numbers.contains(bonusNumber)

        return Rank.valueOf(counts, bonusCheck)
    }

    companion object {

        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}
