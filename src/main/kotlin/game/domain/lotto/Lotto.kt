package game.domain.lotto

private val LOTTO_NUMBER_RANGE = 1..45
private const val LOTTO_TICKET_SIZE = 6

class Lotto(val tickets: List<LottoTicket>) {
    init {
        require(tickets.isNotEmpty()) { "로또는 1장 이상의 티켓으로 구성됩니다." }
    }
}

class LottoTicket(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_TICKET_SIZE) { "로또는 한 장에 ${LOTTO_TICKET_SIZE}개의 중복되지 않은 숫자로 이루어져 있습니다." }
    }

    companion object {
        fun from(numbers: Collection<Int>): LottoTicket {
            return LottoTicket(numbers.map { LottoNumber.from(it) }.toSet())
        }

        private fun random(): LottoTicket {
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

@JvmInline
value class LottoNumber private constructor(val value: Int) {
    init {
        require(LOTTO_NUMBER_RANGE.contains(value)) { "로또 번호는 ${LOTTO_NUMBER_RANGE}이어야 합니다" }
    }

    companion object {
        internal val LOTTO_NUMBER_CACHE = LOTTO_NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber {
            return LOTTO_NUMBER_CACHE[value] ?: throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBER_RANGE}의 범위입니다.")
        }
    }
}
