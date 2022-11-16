package lotto.domain

private const val LOTTO_TICKET_SIZE = 6

class LottoTicket(
    val lottoNumbers: Set<LottoNumber>
) {
    init {
        require(lottoNumbers.size == LOTTO_TICKET_SIZE) {"로또 티켓의 번호는 6개의 숫자로 이루어져야 합니다."}
    }

    fun hasNumber(number: LottoNumber): Boolean {
        return lottoNumbers.contains(number)
    }

    companion object {
        fun of(numbers: Set<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber(it) }
                .toSet())
        }
    }
}
