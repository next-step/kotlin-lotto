package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Lotto(private val money: Int) {
    init {
        require(money % LOTTO_PRICE_UNIT == 0) { LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE }
    }

    fun buyCount(): Int {
        return money / LOTTO_PRICE_UNIT
    }

    fun lottoIssuance(lottoTicket: LottoTicket): List<LottoTicket> {
        return (1..buyCount()).map { lottoTicket }
    }

    companion object {
        private const val LOTTO_PRICE_UNIT = 1000
        private const val LOTTO_PRICE_UNIT_EXCEPTION_MESSAGE = "구매금액은 1000원 단위로만 가능합니다."
    }
}

class LottoTicket {
    private val lottoNumbers = (1..45).shuffled().take(6).sorted()

    fun numbers(): List<Int> {
        return lottoNumbers
    }

    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers().intersect(winningNumbers.toSet()).size
    }
}

enum class LottoRank(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5000),
    NONE(0, 0);

    companion object {
        fun from(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: NONE
        }
    }
}


class LottoTest : StringSpec({
    "구매금액을 입력하면 몇 개를 구매했는지 반환해야 한다." {
        Lotto(14000).buyCount() shouldBe 14
        Lotto(25000).buyCount() shouldBe 25
    }

    "구매금액은 1000원 단위로만 가능하다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                Lotto(1400)
            }
        exception.message shouldBe "구매금액은 1000원 단위로만 가능합니다."
    }

    "구매한 개수만큼 로또를 발급해야 한다." {
        val lotto = Lotto(14000)
        val lottoTicket = LottoTicket()
        val lottoList = lotto.lottoIssuance(lottoTicket).map { it.numbers() }
        lottoList.size shouldBe 14
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 3개이면 5등이다. (5000원)" {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = List(14000) { LottoTicket() }

        val matchingTicket = lottoTickets.first { ticket ->
            ticket.matchCount(winningNumbers) == 3
        }

        val rank = LottoRank.from(matchingTicket.matchCount(winningNumbers))
        rank shouldBe LottoRank.FIFTH
        rank.prize shouldBe 5000
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 4개이면 4등이다. (50000원)" {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = List(14000) { LottoTicket() }

        val matchingTicket = lottoTickets.first { ticket ->
            ticket.matchCount(winningNumbers) == 4
        }

        val rank = LottoRank.from(matchingTicket.matchCount(winningNumbers))
        rank shouldBe LottoRank.FOURTH
        rank.prize shouldBe 50_000
    }

    "구매한 로또 목록에서 당첨 번호와 일치하는 게 5개이면 3등이다. (1500000원)" {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoTickets = List(14000) { LottoTicket() }

        val matchingTicket = lottoTickets.first { ticket ->
            ticket.matchCount(winningNumbers) == 5
        }

        val rank = LottoRank.from(matchingTicket.matchCount(winningNumbers))
        rank shouldBe LottoRank.THIRD
        rank.prize shouldBe 1_500_000
    }
})