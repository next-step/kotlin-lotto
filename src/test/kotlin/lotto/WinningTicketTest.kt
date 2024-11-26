package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe

class WinningTicketTest : StringSpec({
    "당첨 티켓는 로또 1등 당첨 번호(기본티켓)과 보너스 로또 번호를 입력 받는다" {
        val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)
        val sut = WinningTicket(defaultTicket = lottoTicket, bonusNumber = bonusNumber)

        sut.defaultTicket shouldBe lottoTicket
        sut.bonusNumber shouldBe bonusNumber
    }

    "당첨 티켓는 로또 티켓을 받아 당첨 결과를 조회할 수 있다" {
        val sut =
            WinningTicket(
                defaultTicket = LottoTicket(1, 2, 3, 4, 5, 6),
                bonusNumber = LottoNumber(13),
            )

        forAll(
            row(LottoTicket(1, 2, 3, 4, 5, 6), WinningResult.FIRST),
            row(LottoTicket(2, 3, 4, 5, 6, 13), WinningResult.SECOND),
            row(LottoTicket(2, 3, 4, 5, 6, 7), WinningResult.THIRD),
            row(LottoTicket(3, 4, 5, 6, 7, 8), WinningResult.FOURTH),
            row(LottoTicket(4, 5, 6, 7, 8, 9), WinningResult.FIFTH),
            row(LottoTicket(5, 6, 7, 8, 9, 10), WinningResult.LOSE),
            row(LottoTicket(6, 7, 8, 9, 10, 11), WinningResult.LOSE),
            row(LottoTicket(7, 8, 9, 10, 11, 12), WinningResult.LOSE),
        ) { lottoTicket, expectedResult ->
            val winningResult = sut.checkTicket(lottoTicket)
            winningResult shouldBe expectedResult
        }
    }

    "당첨 티켓 생성 시 1등 당첨 번호 중 하나로 보너스 번호를 추가하려고 하면 IllegalArgumentException 예외를 던진다" {
        val winningTicket = LottoTicket(1, 2, 3, 4, 5, 6)

        winningTicket.numbers.forEach { bonusNumber ->
            shouldThrow<IllegalArgumentException> {
                WinningTicket(defaultTicket = winningTicket, bonusNumber = bonusNumber)
            }
        }
    }

    "당첨 티켓는 로또 티켓을 여러 장 받아 당첨 결과를 목록으로 보여줄 수 있다" {
        val sut =
            WinningTicket(
                defaultTicket = LottoTicket(1, 2, 3, 4, 5, 6),
                bonusNumber = LottoNumber(13),
            )

        val lottoTickets =
            listOf(
                LottoTicket(1, 2, 3, 4, 5, 6),
                LottoTicket(2, 3, 4, 5, 6, 13),
                LottoTicket(2, 3, 4, 5, 6, 7),
                LottoTicket(3, 4, 5, 6, 7, 8),
                LottoTicket(4, 5, 6, 7, 8, 9),
                LottoTicket(5, 6, 7, 8, 9, 10),
                LottoTicket(6, 7, 8, 9, 10, 11),
                LottoTicket(7, 8, 9, 10, 11, 12),
            )

        val winningResults: List<WinningResult> = sut.checkTicketAll(lottoTickets)
        winningResults.size shouldBe lottoTickets.size
        winningResults shouldContainExactlyInAnyOrder
            listOf(
                WinningResult.FIRST,
                WinningResult.SECOND,
                WinningResult.THIRD,
                WinningResult.FOURTH,
                WinningResult.FIFTH,
                WinningResult.LOSE,
                WinningResult.LOSE,
                WinningResult.LOSE,
            )
    }
})
