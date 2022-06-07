package lotto.domain

class LottoTicket(val lottoNumbers: Set<LottoNumber>) {
    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_LENGTH) { "로또 번호는 6자리여야 합니다." }
    }

    companion object {
        private const val LOTTO_NUMBERS_LENGTH = 6
    }
}
