package lotto

<<<<<<< HEAD
class Lotto(private val numbers: Set<Int>) {

    val lottoNumber get() = numbers
=======
class Lotto(private val number: Set<Int>) {
    private val _numbers = mutableListOf<Int>()
    private val _sampleTest: List<Int> = listOf(1, 2, 3, 4, 5, 7)
    val numbers: List<Int> get() = _numbers
>>>>>>> fc70a137d48ae697cf8d06fd1356b09f994d7715

    init {
        require(numbers.size == 6) {
            "로또 숫자는 6개 입니다."
        }
<<<<<<< HEAD
    }

=======
        _numbers.addAll(number)
    }
  
>>>>>>> fc70a137d48ae697cf8d06fd1356b09f994d7715
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
