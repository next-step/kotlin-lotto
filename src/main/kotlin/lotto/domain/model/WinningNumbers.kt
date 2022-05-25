package lotto.domain.model

@JvmInline
value class WinningNumbers(val value: List<Int>) {
    init {
        require(value.size == Lotto.LOTTO_NUMBER_COUNT) {
            MESSAGE_INVALID_WINNING_NUMBERS_SIZE
        }
    }

    companion object {
        private const val MESSAGE_INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 6개가 입력되어야 합니다."
    }
}
