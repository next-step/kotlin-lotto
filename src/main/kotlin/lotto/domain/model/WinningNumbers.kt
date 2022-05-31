package lotto.domain.model

data class WinningNumbers(
    val numbers: Set<LottoNumber>,
    val bonusBall: LottoNumber = LottoNumber[7]
) {
    init {
        require(numbers.size == Lotto.LOTTO_NUMBER_COUNT) {
            MESSAGE_INVALID_WINNING_NUMBERS_SIZE
        }
    }

    companion object {
        private const val MESSAGE_INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 6개가 입력되어야 합니다."

        fun of(numbers: List<Int>, bonusBall: LottoNumber = LottoNumber[7]): WinningNumbers {
            return WinningNumbers(
                numbers = numbers.map { LottoNumber[it] }.toSet(),
                bonusBall = bonusBall
            )
        }

        fun default(): WinningNumbers {
            return WinningNumbers(
                setOf(
                    LottoNumber[1],
                    LottoNumber[2],
                    LottoNumber[3],
                    LottoNumber[4],
                    LottoNumber[5],
                    LottoNumber[6]
                ),
                LottoNumber[7]
            )
        }
    }
}
