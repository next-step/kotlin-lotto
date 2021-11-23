package lotto.domain

private const val LOTTO_NUMBER_SIZE = 6

@JvmInline
value class Lotto(private val values: List<LottoNumber>) {
    init {
        require(values.size == LOTTO_NUMBER_SIZE) { "하나의 티켓은 ${LOTTO_NUMBER_SIZE}개의 번호로 이루어져야합니다." }
        require(values.distinct().size == values.size) { "하나의 티켓에 중복된 번호가 있을 수 없습니다." }
    }

    fun toList() = values.toList()

    fun matchCount(other: Lotto): Int = values.intersect(other.values).size

    companion object {
        fun of(values: String?): Lotto {
            require(!values.isNullOrBlank()) { "티켓 번호들은 빈 값이거나 null일 수 없습니다." }
            return of(values.split(",").map { it.trim().toInt() })
        }

        fun of(vararg values: Int): Lotto {
            return of(values.toList())
        }

        private fun of(values: List<Int>): Lotto {
            return Lotto(values.map { LottoNumber(it) })
        }

        fun random(): Lotto = Lotto(
            LottoNumberFactory.numbers()
                .shuffled()
                .take(LOTTO_NUMBER_SIZE)
                .sortedBy { it.value }
        )
    }
}
