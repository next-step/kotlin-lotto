package lotto.domain

class Lotto(private val inputNumberList: List<Int>) {

    val numberList: List<Int> = inputNumberList.sorted()

    init {
        require(numberList.all { it in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX }) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }

        require(numberList.size == Lotto.NUMBER_COUNT_MAX) { "로또 번호는 6개만 가능합니다." }

        require(numberList.distinct().size == numberList.size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getMatchCount(lotto: Lotto): Int = this.numberList.intersect(lotto.numberList.toSet()).size

    fun isContainsBonusNumber(bonusNumber: Int): Boolean = this.numberList.contains(bonusNumber)

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val LOTTO_NUMBER_MIN: Int = 1
        const val LOTTO_NUMBER_MAX: Int = 45
        const val NUMBER_COUNT_MIN: Int = 0
        const val NUMBER_COUNT_MAX: Int = 6
    }
}
