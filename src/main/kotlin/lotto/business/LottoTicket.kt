package lotto.business

class LottoTicket(private val lottoNumbers: List<LottoNumber>) {
    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count { this.lottoNumbers.contains(it) }
    }

    init {
        require(lottoNumbers.distinct().size == LOTTO_NUMBER_SIZE) { "서로 다른 6개 로또 번호 이여야 합니다." }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
    }
}
