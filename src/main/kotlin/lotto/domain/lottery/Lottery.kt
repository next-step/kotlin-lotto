package lotto.domain.lottery

open class Lottery(private val lottoNumber: LottoNumber) {
    init {
        validateNumberSize()
        validateEachNumberInRange()
    }

    private fun validateNumberSize() {
        require(lottoNumber.size == LOTTERY_NUMBER_SIZE) { "로또는 6자리입니다." }
    }

    private fun validateEachNumberInRange() {
        require(lottoNumber.all { it in LOTTERY_NUMBER_RANGE }) { "로또의 숫자는 1~45 사이의 정수가 가능합니다." }
    }

    fun isInBonus(bonus: Int) = bonus in lottoNumber

    infix fun intersect(other: Lottery): Set<Int> {
        return lottoNumber.intersect(other.lottoNumber)
    }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
        val LOTTERY_NUMBER_RANGE = (1..45)
    }

    override fun toString(): String {
        return "${lottoNumber.sorted()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lottery

        return lottoNumber == other.lottoNumber
    }

    override fun hashCode(): Int {
        return lottoNumber.hashCode()
    }
}
