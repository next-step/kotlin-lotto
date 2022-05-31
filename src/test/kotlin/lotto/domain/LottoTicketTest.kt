package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTicketTest : StringSpec({

    "로또 티켓은 6개의 숫자를 가지고 있다" {
        val lottoTicket = LottoTicket.AutoLottoTicket(1, 2, 3, 4, 5, 6)
        lottoTicket.size shouldBe 6
    }

    "로또 티켓은 1~45 범위의 숫자를 입력하지 않은 경우 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket.AutoLottoTicket(0, 2, 3, 4, 5, 6)
        }
    }

    "로또 티켓은 6개 이하의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket.AutoLottoTicket(1)
        }
    }

    "로또 티켓은 6개 이상의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoTicket.AutoLottoTicket(1, 2, 3, 4, 5, 6, 7)
        }
    }

    "로또 티켓은 지난주 당첨번호로부터 LottoMatch를 얻을 수 있다." {
        val lottoTicket = LottoTicket.AutoLottoTicket(1, 2, 3, 4, 5, 6)
        forAll(
            row(
                LottoLastNumbers(setOf(1, 2, 3, 4, 5, 6), 7),
                LottoMatch.SIX
            ),
            row(
                LottoLastNumbers(setOf(1, 2, 3, 4, 5, 7), 6),
                LottoMatch.FIVE_WITH_BONUS
            ),
            row(
                LottoLastNumbers(setOf(1, 2, 3, 4, 5, 7), 8),
                LottoMatch.FIVE
            ),
            row(
                LottoLastNumbers(setOf(1, 2, 3, 4, 7, 8), 9),
                LottoMatch.FOUR
            ),
            row(
                LottoLastNumbers(setOf(1, 2, 3, 7, 8, 9), 10),
                LottoMatch.THREE
            ),
            row(
                LottoLastNumbers(setOf(11, 12, 13, 14, 15, 16), 17),
                LottoMatch.ZERO
            )
        ) { lastNumbers, expectedMatch ->
            val match = lottoTicket.getMatch(lastNumbers)
            match shouldBe expectedMatch
        }
    }
})
