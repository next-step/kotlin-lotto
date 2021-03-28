package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTests {
    @Test
    fun `로또 생성시 6개의 숫자를 가지고 있어야 한다`() {
        val lottoTicket: LottoTicket = LottoTicket(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lottoTicket.size)
            .isEqualTo(6)
    }

    @Test
    fun `로또 생성시 제너레이터에 의존해야한다`() {
        val lottoTicket: LottoTicket = LottoTicket(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lottoTicket)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `로또 번호와 당첨번호와 매칭하여 가져와야 한다`() {
        val lottoTicket: LottoTicket = LottoTicket(generator = 순차적으로_증가하는_로또번호_제너레이터())

        val rank: Rank = LottoWonNumbers(setOf(1, 2, 3, 4, 44, 45), 43).match(
            lottoTicket
        )

        assertThat(rank)
            .isEqualTo(Rank.getRankByCount(4, false))

        assertThat(lottoTicket)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `로또의 숫자는 중첩이 불가능하다 마지막 숫자인 6이 맨 끝에 있으므로 queue는 empty가 되어야 한다`() {
        val 중첩된숫자가쫀재하는제너레이터 = 중첩된_숫자가_쫀재하는_제너레이터()

        val lottoTicket: LottoTicket = LottoTicket(generator = 중첩된숫자가쫀재하는제너레이터)

        assertThat(lottoTicket.size)
            .isEqualTo(6)
        assertThat(lottoTicket)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `5개가 맞고, 1개의 보너스가 맞으면은 2등이다 `() {
        val lottoTicket: LottoTicket = LottoTicket(generator = 순차적으로_증가하는_로또번호_제너레이터())

        val wonNumbers: LottoWonNumbers = LottoWonNumbers(setOf(1, 2, 3, 4, 5, 10), 6)

        assertThat(wonNumbers.match(lottoTicket))
            .isEqualTo(Rank.SECOND)
    }

    @Test
    fun `직접 입력한 로또를 포함하여 자동생성이 가능해야 한다`() {
        val manualTicket = LottoTicket(generator = 순차적으로_증가하는_로또번호_제너레이터())
        val manualLottoTickets = LottoTickets(listOf(manualTicket))

        val lottoTickets = LottoTickets(1, manualLottoTickets)

        assertThat(lottoTickets.size)
            .isEqualTo(2)

        assertThat(lottoTickets)
            .contains(manualTicket)
    }

    fun 순차적으로_증가하는_로또번호_제너레이터(): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            override fun pickNumber(): Set<LottoNumber> = (1..6).map(::LottoNumber).toSet()
        }
    }

    fun 중첩된_숫자가_쫀재하는_제너레이터(): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            override fun pickNumber(): Set<LottoNumber> =
                listOf(1, 2, 3, 1, 4, 2, 1, 2, 3, 1, 4, 5, 1, 1, 4, 3, 2, 5, 6).map(::LottoNumber).toSet()
        }
    }

    fun LottoNumber(number: Int): LottoNumber = LottoNumber.from(number)
}
