package lotto.domain

class LottoUsedTicket(
    private val lottoNumbers: LottoNumbers
) {

    fun evaluate(winTicket: LottoWinTicket): LottoReward {
        return winTicket.matches(lottoNumbers)
    }

    override fun toString(): String {
        return "[$lottoNumbers]"
    }
}
