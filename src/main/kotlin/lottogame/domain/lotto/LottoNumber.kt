package lottogame.domain.lotto

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in NUMBER_RANGE) { "${MIN_NUMBER}부터 $MAX_NUMBER 사이의 숫자만 입력할 수 있습니다. [$value]" }
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        val NUMBER_RANGE = MIN_NUMBER..MAX_NUMBER
    }
}
