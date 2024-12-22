package lotto.model.number

class LottoNumbers(
    private val lottoNumbers: List<Int>,
) : List<Int> by lottoNumbers {
    init {
        require(lottoNumbers.size == DEFAULT_LOTTO_COUNT) {
            "로또 번호는 ${DEFAULT_LOTTO_COUNT}개여야 합니다."
        }
        require(lottoNumbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "로또 번호는 $LOTTO_MIN_NUMBER ~ $LOTTO_MAX_NUMBER 사이여야 합니다."
        }
        require(lottoNumbers.distinct().size == lottoNumbers.size) {
            "로또 번호는 중복될 수 없습니다."
        }
    }

    override fun toString(): String {
        return "$lottoNumbers"
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val DEFAULT_LOTTO_COUNT = 6
        private val NUMBERS = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)

        fun issuanceLottoNumbers(lottoCount: Int = DEFAULT_LOTTO_COUNT): LottoNumbers {
            val lottoNumbers =
                NUMBERS.shuffled().take(lottoCount)
                    .sorted()
            return LottoNumbers(lottoNumbers)
        }

        fun issuanceLottoTickets(
            ticketCount: Int,
            lottoCount: Int = DEFAULT_LOTTO_COUNT,
        ): List<LottoNumbers> {
            return List(ticketCount) {
                issuanceLottoNumbers(lottoCount)
            }
        }
    }
}
