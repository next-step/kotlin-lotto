package lotto.domain

class LottoTicket(val lottoNumbers: List<LottoNumber>) {

    init {
        validateLottoNumbers(lottoNumbers)
    }

    private fun validateLottoNumbers(lottoNumbers: List<LottoNumber>) {
        if (lottoNumbers.size != LOTTO_NUMBER_COUNT_PER_TICKET) {
            throw IllegalArgumentException(NOT_FULFILL_TICKET_SIZE)
        }
        if (lottoNumbers.size != getLottoNumbers(lottoNumbers).distinct().size) {
            throw IllegalArgumentException(NOT_ALLOW_DISTINCT_NUM)
        }
    }

    fun getMatchValueCount(winningLotto: LottoTicket): Int {
        return getLottoNumbers(lottoNumbers).count { getLottoNumbers(winningLotto.lottoNumbers).contains(it) }
    }

    fun isExistBonusBall(bonusBall: LottoNumber): Boolean {
        return getLottoNumbers(lottoNumbers).contains(bonusBall.number)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT_PER_TICKET = 6
        const val NOT_FULFILL_TICKET_SIZE = "6개의 번호가 필요합니다."
        const val NOT_ALLOW_DISTINCT_NUM = "로또 번호는 중복될 수 없습니다."

        private fun getLottoNumbers(lottoNumbers: List<LottoNumber>): List<Int> {
            return lottoNumbers.map { it.number }.sorted()
        }

        fun from(lottoNumbers: List<LottoNumber>): LottoTicket {
            return LottoTicket(lottoNumbers)
        }
    }
}
