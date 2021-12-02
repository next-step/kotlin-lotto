package lotto.domain

class LottoTicket private constructor(val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    fun countWith(winningNumbers: WinningNumbers): MatchingCount =
        MatchingCount(
            winningNumbers.winningNumbers.count { numbers.contains(it) },
            numbers.contains(winningNumbers.bonusNumber)
        )

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val ONE_THOUSAND = 1000

        fun generateByAuto(): LottoTicket {
            return LottoTicket(
                (LottoNumber.MINIMUM_NUMBER..LottoNumber.MAXIMUM_NUMBER)
                    .shuffled()
                    .subList(0, 6)
                    .sorted()
                    .map(LottoNumber::from)
            )
        }

        fun generateByManual(numbers: List<Int>): LottoTicket {
            return LottoTicket(numbers.map(LottoNumber::from))
        }

        fun getCostForOneTicket(): Int {
            return ONE_THOUSAND
        }

        fun validateInTheThousands(value: Int) {
            require(value % ONE_THOUSAND == 0) {
                "금액 단위는 1000원입니다."
            }
        }

        fun validateMoreThan1000(value: Int) {
            require(value >= ONE_THOUSAND) {
                "최소 금액은 1000원입니다."
            }
        }
    }
}
