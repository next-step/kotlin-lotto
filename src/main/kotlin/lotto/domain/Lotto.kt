package lotto.domain

data class Lotto(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { LOTTO_SIZE_ERROR_MESSAGE }
    }

    val size: Int = numbers.size

    operator fun contains(number: LottoNumber): Boolean = number in numbers

    override fun toString(): String = numbers.joinToString(", ", "[", "]")

    companion object {
        const val LOTTO_PRICE = 1000
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_WINNING_MIN_COUNT = 3

        const val LOTTO_SIZE_ERROR_MESSAGE = "로또는 ${LOTTO_NUMBER_SIZE}개의 숫자여야 합니다."
    }
}
