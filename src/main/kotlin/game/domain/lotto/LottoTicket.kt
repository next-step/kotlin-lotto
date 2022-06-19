package game.domain.lotto

private const val LOTTO_TICKET_SIZE = 6

class LottoTicket(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_TICKET_SIZE) { "로또는 한 장에 ${LOTTO_TICKET_SIZE}개의 중복되지 않은 숫자로 이루어져 있습니다." }
    }

    companion object {
        fun from(numbers: Collection<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.from(it) }.toSet())
        }
    }
}
