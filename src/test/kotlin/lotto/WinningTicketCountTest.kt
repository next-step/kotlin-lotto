package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.model.vo.WinningTicketCount


/**
 * 당첨된 로또 티켓 카운트 테스트
 * */
class WinningTicketCountTest : FunSpec({
    test("당첨된 로또 티켓 카운트 생성시 '-1000'을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningTicketCount.valueOf(-1000)
        }
    }

    test("당첨된 로또 티켓 카운트 생성시 '-100'을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningTicketCount.valueOf(-100)
        }
    }

    test("당첨된 로또 티켓 카운트 생성시 '-10'을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningTicketCount.valueOf(-10)
        }
    }

    test("당첨된 로또 티켓 카운트 생성시 '-1'을 입력할 경우 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            WinningTicketCount.valueOf(-1)
        }
    }

    test("당첨된 로또 티켓 카운트 생성시 `3`을 입력할 경우 `3`개의 횟수를 가진 당첨 로또 티켓 카운트가 생성되어야 한다.") {
        WinningTicketCount.valueOf(3).ticketCount shouldBe 3
    }

    test("당첨된 로또 티켓 카운트 생성시 `100`을 입력할 경우 `100`개의 횟수를 가진 당첨 로또 티켓 카운트가 생성되어야 한다.") {
        WinningTicketCount.valueOf(100).ticketCount shouldBe 100
    }

})
