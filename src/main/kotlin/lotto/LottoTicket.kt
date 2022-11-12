package lotto

class LottoTicket(
    val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == 6)
    }

    companion object {
        fun of(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber(it) }
                .toSet())
        }
    }
}