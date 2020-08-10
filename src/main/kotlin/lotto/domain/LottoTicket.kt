package lotto.domain

class LottoTicket(val lottoNumbers: List<LottoNumber>) {

    init {
        validateLottoNumbers(lottoNumbers)
    }

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        if (lottoNumbers.size != LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException("6개의 번호가 필요합니다.")
        }
        if (lottoNumbers.size != getLottoNumber().distinct().size) {
            throw IllegalArgumentException("로또 번호는 중복될 수 없습니다.")
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
