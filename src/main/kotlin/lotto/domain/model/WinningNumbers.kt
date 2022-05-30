package lotto.domain.model

@JvmInline
value class WinningNumbers(val value: Set<LottoNumber>) {
    init {
        require(value.size == Lotto.LOTTO_NUMBER_COUNT) {
            MESSAGE_INVALID_WINNING_NUMBERS_SIZE
        }
    }

    companion object {
        private const val MESSAGE_INVALID_WINNING_NUMBERS_SIZE = "당첨 번호는 6개가 입력되어야 합니다."

        fun from(numbers: List<Int>): WinningNumbers {
            return WinningNumbers(numbers.map { LottoNumber(it) }.toSet())
        }

        fun default(): WinningNumbers {
            return WinningNumbers(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            )
        }
    }
}
