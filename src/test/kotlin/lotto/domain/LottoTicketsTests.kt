package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoTicketsTests {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `여러개의 로또를 구매가 가능하다`(count: Int) {
        val lottoTickets: LottoTickets = LottoTickets(count)

        assertThat(lottoTickets.lottoTickets.size)
            .isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0])
    fun `로또는 1개이상 구매가 가능하다`(count: Int) {
        assertThrows<IllegalArgumentException> { LottoTickets(count) }
    }

    @Test
    fun `원하는대로 생성해서 당첨 갯수와 총액을 구해보자`() {
        val wonNumber: Set<LottoNumber> = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val firstWonNumber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 3, 4, 5, 6))
        val thirdWonNumber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 3, 4, 5, 45))
        val fourthWonNumber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 3, 4, 44, 45))
        val fifthWonNumber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 3, 43, 44, 45))
        val failWonNUmber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 42, 43, 44, 45))
        val secondWonNumber = 원하는_대로_만들어_주는_제너레이터(random = listOf(1, 2, 3, 4, 5, 10))

        // 1등 2개,
        // 2등 1개
        // 3등 1개
        // 4등 3개
        // 실패 2개
        val lottoTickets: LottoTickets = LottoTickets(
            mutableListOf(
                LottoTicket(firstWonNumber),
                LottoTicket(firstWonNumber),
                LottoTicket(thirdWonNumber),
                LottoTicket(fourthWonNumber),
                LottoTicket(fifthWonNumber),
                LottoTicket(fifthWonNumber),
                LottoTicket(fifthWonNumber),
                LottoTicket(failWonNUmber),
                LottoTicket(failWonNUmber),
                LottoTicket(secondWonNumber),
                LottoTicket(secondWonNumber)
            )
        )

        val matchByWonNumber = LottoWonNumbers(wonNumber, LottoNumber(10)).match(lottoTickets)

        assertThat(matchByWonNumber.rankCount[Rank.FIRST])
            .isEqualTo(2)
        assertThat(matchByWonNumber.rankCount[Rank.THIRD])
            .isEqualTo(1)
        assertThat(matchByWonNumber.rankCount[Rank.FOURTH])
            .isEqualTo(1)
        assertThat(matchByWonNumber.rankCount[Rank.FIFTH])
            .isEqualTo(3)
        assertThat(matchByWonNumber.rankCount[Rank.FAIL])
            .isEqualTo(2)
        assertThat(matchByWonNumber.rankCount[Rank.SECOND])
            .isEqualTo(2)

        assertThat(matchByWonNumber.sumAmount)
            .isEqualTo(
                Rank.FIRST.amount * 2 + Rank.THIRD.amount * 1 + Rank.FOURTH.amount * 1 + Rank.FIFTH.amount * 3 + Rank.SECOND.amount * 2
            )
    }

    fun 원하는_대로_만들어_주는_제너레이터(random: List<Int>): LottoNumberGenerator {

        return object : LottoNumberGenerator {
            override fun pickNumber(): Set<LottoNumber> = random.map(::LottoNumber).toSet()
        }
    }
}
