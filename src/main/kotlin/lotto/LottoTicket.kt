package lotto

class LottoTicket(
    private val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == 6)
    }

    fun count(predicate: (LottoNumber) -> Boolean): Int {
        return lottoNumbers.count { predicate(it) }
    }

    companion object {
        fun of(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber(it) }
                .toSet())
        }
    }
}