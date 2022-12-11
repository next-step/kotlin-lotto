package lotto.domain

@JvmInline
value class Lottery(
    private val value: List<LotteryNumber>,
) {

    init {
        require(value.distinct().size == value.size) {
            IllegalArgumentException("중복인 번호가 존재합니다.")
        }

        require(value.size == SIZE_OF_LOTTO_NUMBERS) {
            IllegalArgumentException("${SIZE_OF_LOTTO_NUMBERS}개의 번호가 필요합니다.")
        }
    }

    fun calculateMatch(winningNumbers: List<LotteryNumber>): Int = winningNumbers.count { winningNumber ->
        value.contains(winningNumber)
    }

    override fun toString(): String = value
        .map { number ->
            number.toString()
        }
        .toString()

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6
    }
}
