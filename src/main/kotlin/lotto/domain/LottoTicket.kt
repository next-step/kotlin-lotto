package lotto.domain

class LottoTicket(var lottoNumbers: List<LottoNumber>) {

    init {
        createLottoNumbers(lottoNumbers)
    }

    private fun createLottoNumbers(lottoNumbers: List<LottoNumber>) {
        validateLottoNumbers(lottoNumbers)
        this.lottoNumbers = lottoNumbers
    }

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        if (lottoNumbers.size != LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException("로또 번호는 6자리여야합니다.")
        }
        if (lottoNumbers.size != getLottoNumber().distinct().size) {
            throw IllegalArgumentException("로또 번호는 중복불가능합니다")
        }
    }

    private fun getLottoNumber(): List<Int> {
        return lottoNumbers.map { it.number }.sorted()
    }

    fun getMatchValueCount(winningLotto: LottoTicket): Rank {
        return getLottoNumber().count { winningLotto.getLottoNumber().contains(it) }.let { Rank.of(it) }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT_PER_TICKET = 6
    }
}
