package lotto.domain

class LottoWinTicket(
    private val winNumbers: LottoNumbers
) {

    fun matches(inputNumbers: LottoNumbers): LottoReward {
        val matchCount = winNumbers.matches(inputNumbers)

        return LottoReward.from(matchCount)
    }

    companion object {
        fun from(input: String): LottoWinTicket {
            return LottoWinTicket(
                LottoNumbers.from(input)
            )
        }
    }
}
