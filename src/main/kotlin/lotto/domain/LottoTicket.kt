package lotto.domain

class LottoTicket private constructor(
    val lottoNumbers: List<LottoNumber>
) {

    override fun toString(): String {
        return "[${lottoNumbers.joinToString(", ")}]"
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
        private val LOTTO_NUMBER_CANDIDATES: List<LottoNumber> =
            (LottoNumber.MINIMUM_LOTTO_NUMBER..LottoNumber.MAXIMUM_LOTTO_NUMBER)
                .map { LottoNumber.from(it) }

        fun create(): LottoTicket {
            return LottoTicket(LOTTO_NUMBER_CANDIDATES.shuffled().take(LOTTO_NUMBERS_SIZE))
        }
    }
}
