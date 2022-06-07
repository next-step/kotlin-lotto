package lotto

@JvmInline
value class LottoTicket(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(this.lottoNumbers.size == LOTTO_NUMBERS_SIZE)
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6
    }
}
