package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTicketKoTest : StringSpec({

    "1부터 45사이의 6자리 숫자로 로또 티켓 생성 성공" {
        LottoTicket(listOf(1, 2, 3, 43, 44, 45))
    }

    "1부터 45 범위를 벗어난 숫자를 입력하면 에러" {
        listOf(
            listOf(-1, 2, 3, 43, 44, 45),
            listOf(0, 2, 3, 43, 44, 45),
            listOf(1, 2, 3, 43, 44, 46),
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoTicket(it)
            }
        }
    }

    "6자리가 아닌 숫자를 입력하면 에러" {
        listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 6, 7),
        ).forAll {
            shouldThrow<IllegalArgumentException> {
                LottoTicket(it)
            }
        }
    }

    "당첨 결과" {
        mapOf(
            listOf(1, 2, 3, 4, 5, 6) to WinResult.FIRST,
            listOf(1, 2, 3, 4, 5, 44) to WinResult.THIRD,
            listOf(1, 2, 3, 4, 5, 45) to WinResult.THIRD,
            listOf(1, 2, 3, 4, 44, 45) to WinResult.FOURTH,
            listOf(1, 2, 3, 43, 44, 45) to WinResult.FIFTH,
            listOf(1, 2, 42, 43, 44, 45) to WinResult.LOSE,
        ).forAll { (winNumbers, winResult) ->
            val bonusNumber = 44
            LottoTicket(listOf(1, 2, 3, 4, 5, 6)).getWinResult(LottoTicket(winNumbers), bonusNumber) shouldBe winResult
        }
    }
})
