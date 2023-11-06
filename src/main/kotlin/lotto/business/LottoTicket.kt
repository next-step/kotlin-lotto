package lotto.business

class LottoTicket(lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) { "서로 다른 ${LOTTO_NUMBER_SIZE}개 로또 번호 이여야 합니다." }
    }

    private val _sortedLottoNumbers = lottoNumbers.sortedBy { it.number }

    val lottoNumbers: List<String>
        get() = _sortedLottoNumbers
            .map { it.number.toString() }

    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count(_sortedLottoNumbers::contains)
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
