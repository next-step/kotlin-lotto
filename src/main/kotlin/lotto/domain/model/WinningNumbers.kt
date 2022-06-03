package lotto.domain.model

data class WinningNumbers(
    val numbers: Lotto,
    val bonusBall: LottoNumber
) {
    init {
        require(numbers.numbers.size == Lotto.LOTTO_NUMBER_COUNT) {
            MESSAGE_INVALID_WINNING_NUMBERS_SIZE
        }
        require(bonusBall !in numbers.numbers) {
            MESSAGE_DUPLICATE_WINNING_NUMBERS
        }
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean = lottoNumber in numbers.numbers

    companion object {
        private const val MESSAGE_INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 6개가 입력되어야 합니다."
        private const val MESSAGE_DUPLICATE_WINNING_NUMBERS = "보너스 볼 번호는 당첨 번호와 중복될 수 없습니다."

        fun from(numbers: Lotto, bonusBall: LottoNumber): WinningNumbers {
            return WinningNumbers(numbers, bonusBall)
        }
    }
}
