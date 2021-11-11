package lotto

private const val LOTTO_NUMBER_SIZE = 6
@JvmInline
value class Ticket(private val numbers: List<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { "하나의 티켓은 ${LOTTO_NUMBER_SIZE}개의 번호로 이루어져야합니다."}
        require(numbers.distinct().size == numbers.size) { "하나의 티켓에 중복된 번호가 있을 수 없습니다." }
    }
    companion object {
        fun of(vararg values: Int): Ticket {
            return of(values.toList())
        }

        fun random(): Ticket {
            TODO()
        }

        private fun of(values: List<Int>): Ticket {
            return Ticket(values.map { LottoNumber(it) })
        }
    }
}
