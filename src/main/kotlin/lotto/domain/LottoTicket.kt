package lotto.domain

class LottoTicket(private val lottoNumbers: Set<LottoNumber>) {

    init {
        validSizeNumbers()
    }

    private fun validSizeNumbers() {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "입력된 로또 숫자 개수가 올바르지 않습니다 : ${lottoNumbers.size} 개 입력함"
        }
    }

    fun getCollectCount(winLottoTicket: LottoTicket): Int {
        return winLottoTicket.lottoNumbers
            .map { this.lottoNumbers.contains(it) }
            .count { it }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun of(numbers: List<Int>): LottoTicket {
            val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()
            return LottoTicket(lottoNumbers)
        }
    }
}
