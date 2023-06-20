package lotto.domain.lottery

open class Lottery(private val lottoNumbers: Set<LotteryNumber>) {
    init {
        validateNumberSize()
    }

    private fun validateNumberSize() {
        require(lottoNumbers.size == LOTTERY_NUMBER_SIZE) { "로또는 6자리입니다." }
    }

    fun isInBonus(bonus: LotteryNumber) = bonus in lottoNumbers

    infix fun intersect(other: Lottery): Set<LotteryNumber> {
        return lottoNumbers.intersect(other.lottoNumbers)
    }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6
    }

    override fun toString(): String {
        return "${lottoNumbers.sorted()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Lottery

        return lottoNumbers == other.lottoNumbers
    }

    override fun hashCode(): Int {
        return lottoNumbers.hashCode()
    }
}
