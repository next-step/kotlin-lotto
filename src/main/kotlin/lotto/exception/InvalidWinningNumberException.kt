package lotto.exception

class InvalidWinningNumberException(message: String) : IllegalArgumentException(message) {
    companion object {
        const val INVALID_WINNING_NUMBER_MESSAGE = "당첨 번호는 6개로 이루어져 있습니다. 다시 입력해주세요."
        const val INVALID_WINNING_NUMBER_RANGE_MESSAGE = "당첨 번호는 1 ~ 45 범위의 숫자로만 구성될 수 있습니다."
    }
}
