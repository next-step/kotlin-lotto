package lotto.domain

@JvmInline
value class LottoTicket private constructor(val numbers: List<Int>) {
    fun countWith(winningNumbers: WinningNumbers): MatchingCount =
        MatchingCount(winningNumbers.winningNumbers.count { numbers.contains(it) },
            numbers.contains(winningNumbers.bonusNumber))

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val ONE_THOUSAND = 1000

        fun generateByAuto(): LottoTicket {
            return LottoTicket((1..45).shuffled().subList(0, 6).sorted())
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
