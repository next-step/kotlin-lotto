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

    fun getMatchCount(winLottoTicket: LottoTicket): Int {
        return winLottoTicket.lottoNumbers
            .count { it in lottoNumbers }
    }

    override fun toString(): String {
        return lottoNumbers.joinToString(", ", "[", "]")
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumber in this.lottoNumbers
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun of(numbers: List<Int>): LottoTicket {
            val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()
            return LottoTicket(lottoNumbers)
        }
    }
}
