package lotto.domain

data class LottoTicket(val lottoNumbers: List<LottoNumber>) {
    init {
        val lottoNumbersSize = lottoNumbers.distinct().size
        require(lottoNumbersSize == LOTTO_NUMBERS_SIZE) {
            "로또 티켓은 서로 다른 ${LOTTO_NUMBERS_SIZE}개의 로또 숫자만 생성 가능합니다"
        }
    }

    fun matching(other: LottoTicket): Int {
        return lottoNumbers.count { other.lottoNumbers.contains(it) }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    companion object {
        const val LOTTO_NUMBERS_SIZE = 6

        fun of(value: String, delimiter: String = ", "): LottoTicket {
            val lottoNumbers = value.split(delimiter)
                .map { it.toInt() }
            return of(lottoNumbers)
        }

        fun of(value: List<Int>): LottoTicket {
            return LottoTicket(value.map(::LottoNumber))
        }
    }
}
