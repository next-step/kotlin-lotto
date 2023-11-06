package lotto.business

class LottoTicket(override val lottoNumbers: Set<LottoNumber>) : LottoNumberSet {
    init {
        validateNumbers()
    }

    private val _sortedLottoNumbers = sortedLottoNumbers()

    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count(_sortedLottoNumbers::contains)
    }
}
