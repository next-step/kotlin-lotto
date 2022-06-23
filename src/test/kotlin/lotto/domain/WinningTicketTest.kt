package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class WinningTicketTest : FreeSpec({

    "당첨 번호와 보너스 번호가 중복될 경우 예외가 발생한다." {
        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            WinningTicket.of(
                lottoNumbers = listOf(1, 2, 3, 4, 5, 6),
                bonusNumber = 1
            )
        }

        // then
        exception.message shouldBe "보너스 번호는 당첨 번호들과 중복될 수 없습니다."
    }

    "당첨 번호와 보너스 번호를 비교하여 당첨 결과를 반환한다." - {
        // given
        val winningTicket = WinningTicket.of(
            lottoNumbers = listOf(1, 2, 3, 4, 5, 6),
            bonusNumber = 7
        )

        listOf(
            row(LottoTicket(1, 2, 3, 4, 5, 6), WinningAmount.FIRST),
            row(LottoTicket(1, 2, 3, 4, 5, 6), WinningAmount.FIRST),
            row(LottoTicket(1, 2, 3, 4, 5, 7), WinningAmount.SECOND),
            row(LottoTicket(1, 2, 3, 4, 5, 44), WinningAmount.THIRD),
            row(LottoTicket(1, 2, 3, 4, 43, 7), WinningAmount.FOURTH),
            row(LottoTicket(1, 2, 3, 4, 43, 44), WinningAmount.FOURTH),
            row(LottoTicket(1, 2, 3, 42, 43, 7), WinningAmount.FIFTH),
            row(LottoTicket(1, 2, 3, 42, 43, 44), WinningAmount.FIFTH),
            row(LottoTicket(1, 2, 41, 42, 43, 7), WinningAmount.MISS),
        ).forEach { (lottoTicket, winningAmount) ->
            "${lottoTicket.lottoNumbers.values.map { it.value }} 의 당첨 결과는 $winningAmount 이다." {
                winningTicket.matchResult(lottoTicket = lottoTicket) shouldBe winningAmount
            }
        }
    }
})
