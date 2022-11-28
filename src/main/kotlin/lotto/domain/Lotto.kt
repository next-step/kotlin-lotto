package lotto.domain

class Lotto(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호는 ${LOTTO_NUMBERS_SIZE}개가 필요합니다." }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
