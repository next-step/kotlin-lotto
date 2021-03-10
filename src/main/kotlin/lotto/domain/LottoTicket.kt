package lotto.domain

class LottoTicket private constructor(private val lottoNumbers: Set<LottoNumber>) {

    init {
        validSizeNumbers()
    }

    private fun validSizeNumbers() {
        require(lottoNumbers.size == LOTTO_NUMBER_SIZE) {
            "입력된 로또 숫자 개수가 올바르지 않습니다 : ${lottoNumbers.size} 개 입력함"
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6

        fun of(numbers: Set<Int>): LottoTicket {
            val lottoNumbers = numbers.map { LottoNumber(it) }.toSet()
            return LottoTicket(lottoNumbers)
        }
    }
}
