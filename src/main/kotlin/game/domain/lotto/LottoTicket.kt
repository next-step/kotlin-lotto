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

        fun random(): LottoTicket {
            val numbers = LottoNumber.LOTTO_NUMBER_CACHE.values
                .shuffled()
                .subList(0, LOTTO_TICKET_SIZE)
                .toSet()
            return LottoTicket(numbers)
        }

        fun random(count: Long): List<LottoTicket> {
            return (count..1).map { random() }
        }
    }
}
