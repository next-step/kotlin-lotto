package lotto.business

class LottoTicket(private val _lottoNumbers: List<LottoNumber>) {
    val lottoNumbers: List<String>
        get() = _lottoNumbers
            .sortedBy { it.number }
            .map { it.number.toString() }

    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count { this._lottoNumbers.contains(it) }
    }

    init {
        require(_lottoNumbers.distinct().size == LOTTO_NUMBER_SIZE) { "서로 다른 6개 로또 번호 이여야 합니다." }
        _lottoNumbers.sortedBy { it.number }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
