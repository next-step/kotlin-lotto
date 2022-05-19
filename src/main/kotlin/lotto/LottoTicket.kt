package lotto

data class LottoTicket(val lottoNumbers: List<LottoNumber>) {
    init {
        val lottoNumbersSize = lottoNumbers
            .distinct()
            .size
        require(lottoNumbersSize == LOTTO_NUMBERS_SIZE) {
            "로또 티켓은 서로 다른 6개의 로또 숫자만 생성 가능합니다"
        }
    }

    fun contains(lottoNumber: LottoNumber): Any {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
    }
}
