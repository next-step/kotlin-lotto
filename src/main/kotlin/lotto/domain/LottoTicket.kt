package lotto.domain

class LottoTicket(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_LENGTH) { "로또 번호는 6자리여야 합니다." }
    }

    fun hasBonusNumber(bonusNumber: Int): Boolean {
        return lottoNumbers.map { it.number }.contains(bonusNumber)
    }

    fun matchCount(lottoTicket: LottoTicket): Int {
        val numbers = lottoTicket.lottoNumbers.map { it.number }
        return lottoNumbers.map { it.number }.filter { numbers.contains(it) }.size
    }

    companion object {
        private const val LOTTO_NUMBERS_LENGTH = 6
    }
}
