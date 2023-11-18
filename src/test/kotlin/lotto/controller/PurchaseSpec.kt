package lotto.controller

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PurchaseSpec: BehaviorSpec({
    given("구입 금액이 주어졌을 때") {
        val inputAmount = "2000"
        val purchaseRequest = PurchaseRequest.from(inputAmount)
        val lottoController = LottoController()

        `when`("로또를 구입 금액 만큼 구매 요청한다.") {
            lottoController.purchase(purchaseRequest)

            then("구입 금액에 맞는 로또 티켓이 생성된다.") {
                lottoController.tickets.size shouldBe 2
            }
        }
    }
})

class LottoController(
    var tickets: List<LottoTicket> = emptyList()
) {
    fun purchase(req: PurchaseRequest) {
        tickets = LottoStore().buyLottoTicket(req.amount)
    }

    fun evaluate(req: EvaluateRequest): LottoResult {
        return LottoTickets(tickets).getTotalResult(req.winningNumbers, req.bonusNumber)
    }
}

class LottoStore() {
    fun buyLottoTicket(amount: Int): List<LottoTicket> {
        val allowedAttempts = amount / 1000
        return List(allowedAttempts) { createAutoLottoTicket() }
    }

    private fun createAutoLottoTicket(): LottoTicket {
        val numbers = (1..45).shuffled().take(6).sorted()

        return LottoTicket(numbers)
    }
}

class LottoTicket(val numbers: List<Int>) {
    fun countSameNumber(other: List<Int>): Int {
        return numbers.intersect(other.toSet()).count()
    }

    fun isMatchBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}

class LottoTickets(val tickets: List<LottoTicket>) {
    fun getTotalResult(winningNumbers: List<Int>, bonusNumber: Int): LottoResult {
        val result = tickets
            .map { ticket ->
                Rank.valueOf(ticket.countSameNumber(winningNumbers), ticket.isMatchBonusNumber(bonusNumber))
            }
            .groupBy { it }
            .mapValues { it.value.size }
            .let(::LottoResult)

        return result
    }
}

class LottoResult(
    val rankCounts: Map<Rank, Int>,
) {
    fun getEarningRate(): Double {
        val totalPrize = rankCounts
            .map { (rank, count) -> rank.winningMoney * count }
            .sum()

        val totalTicketCount = rankCounts
            .map { (_, count) -> count }
            .sum()

        return totalPrize.toDouble() / (totalTicketCount * 1000)
    }
}

enum class Rank(val countOfMatch: Int, val winningMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    companion object {
        fun valueOf(countOfMatch: Int, matchBonus: Boolean): Rank {
            return when (countOfMatch) {
                6 -> FIRST
                5 -> if (matchBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}

