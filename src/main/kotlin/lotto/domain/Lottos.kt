import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Rank

class Lottos(private val tickets: List<Lotto>) {
    init {
        require(tickets.isNotEmpty()) { "로또는 최소 1개 이상 구매해야 합니다." }
    }

    fun size(): Int = tickets.size

    val lottos: List<Lotto>
        get() = tickets.toList()

    fun matchNumber(
        winningNumber: Lotto,
        bonusBall: LottoNumber,
    ): Map<Rank, Int> {
        return tickets
            .map { it.match(winningNumber, bonusBall) }
            .groupBy { it }
            .mapValues { it.value.size }
    }
}
