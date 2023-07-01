package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class WinningTicketTest : FunSpec({
    test("당첨 번호와 일치하는 로또 등수와 당첨 횟수를 반환한다.") {
        // given
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val myNumbers = LottoNumbers(1, 3, 5, 7, 8, 9)
        val lottoTickets = LottoTickets(listOf(myNumbers))
        val hasBonusLottoNumber = LottoNumber(10)
        val winningTicket = WinningTicket(winningNumbers, hasBonusLottoNumber)
        val expected = LottoResult(mapOf(LottoRank.FIFTH to 1))

        // when
        val actual = winningTicket.getMatchingResult(lottoTickets)

        // then
        actual.map shouldBe expected.map
    }

    test("2등을 위해 추가 번호를 하나 더 추첨한다.") {
        // given
        val winningNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val myNumbers = LottoNumbers(1, 2, 3, 4, 5, 10)
        val lottoTickets = LottoTickets(listOf(myNumbers))
        val hasBonusLottoNumber = LottoNumber(10)
        val winningTicket = WinningTicket(winningNumbers, hasBonusLottoNumber)
        val expected = LottoResult(mapOf(LottoRank.SECOND to 1))

        // when
        val actual = winningTicket.getMatchingResult(lottoTickets)

        // then
        actual.map shouldBe expected.map
    }
})
