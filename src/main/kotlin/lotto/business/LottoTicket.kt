package lotto.business

class LottoTicket(lottoNumbers: Set<LottoNumber>) {
    private val _lottoNumbers: Set<LottoNumber> = lottoNumbers

    val lottoNumbers: List<LottoNumber>
        get() = _lottoNumbers.sortedBy { it.number }

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "서로 다른 ${LOTTO_NUMBER_SIZE}개 로또 번호 이여야 합니다."
        }
    }

    fun matchCount(targetLottoNumbers: List<LottoNumber>): Int {
        return targetLottoNumbers.count(lottoNumbers::contains)
    }

    fun contains(targetLottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(targetLottoNumber)
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
