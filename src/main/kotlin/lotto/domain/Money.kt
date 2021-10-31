package lotto.domain

@JvmInline
value class Money private constructor(val value: Int) {
    fun convertToLottoTicketCount(): Int {
        return value / ONE_THOUSAND
    }

    companion object {
        private const val ONE_THOUSAND = 1000

        fun make(value: Int): Money {
            validateMoreThan1000(value)
            validateInTheThousands(value)
            return Money(value)
        }

        private fun validateInTheThousands(value: Int) {
            require(value % 1000 == 0) {
                "금액 단위는 1000원입니다."
            }
        }

        private fun validateMoreThan1000(value: Int) {
            require(value >= 1000) {
                "최소 금액은 1000원입니다."
            }
        }
    }
}
