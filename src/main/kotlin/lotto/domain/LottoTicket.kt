package lotto.domain

@JvmInline
value class LottoTicket private constructor(val numbers: List<Int>) {
    fun countWith(winningNumbers: List<Int>): Int = winningNumbers.filter { numbers.contains(it) }
        .count()

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        fun generateByAuto(): LottoTicket {
            return LottoTicket((1..50).shuffled().subList(0, 6).sorted())
        }
    }
}
