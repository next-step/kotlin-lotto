package lotto

class Lotto(private val number: Set<Int>) {
    private val _numbers = mutableListOf<Int>()
    val numbers: List<Int> get() = _numbers

    init {
        require(number.size == 6) {
            "로또 숫자는 6개 입니다."
        }
        _numbers.addAll(number)
    }

    fun generate() {

        _numbers.addAll(number)
    }

    fun getPrizeWithBonus(winningNumber: List<Int>, bonusNumber: Int): Rank {
        val counts = this._numbers.count { number -> winningNumber.contains(number) }

        val bonusCheck = this.numbers.contains(bonusNumber)


        return Rank.valueOf(counts, bonusCheck)
    }

    companion object {

        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}
