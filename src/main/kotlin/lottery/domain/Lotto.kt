package lottery.domain

data class Lotto(
    val lottoNumber: List<Int>
) {
    init {
        require(lottoNumber.all { it in MIN_NUMBER..MAX_NUMBER }) { INVALID_NUMBER_RANGE_MESSAGE }
        require(lottoNumber.distinct().size == LOTTO_SIZE) { INVALID_LOTTO_SIZE_MESSAGE }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_SIZE = 6
        private const val INVALID_NUMBER_RANGE_MESSAGE = "로또 번호는 1에서 45 사이의 값이어야 합니다."
        private const val INVALID_LOTTO_SIZE_MESSAGE = "로또 번호는 총 6개의 숫자여야 합니다."
    }
}
