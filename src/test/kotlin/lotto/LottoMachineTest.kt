package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.LottoMachine
import lotto.domain.LottoMachine.Companion.TICKET_PRICE
import java.lang.RuntimeException

class LottoMachineTest : FunSpec({
    test("구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 반환한다.") {
        // given
        val lottoMachine = LottoMachine()
        val purchaseAmount = 14000
        val expected = 14

        // when
        val lottoTickets = lottoMachine.buyTickets(purchaseAmount)

        // then
        lottoTickets.numbers shouldHaveSize expected
    }

    test("로또 1장의 가격(1000)보다 구입 금액이 적다면 RuntimeException 예외가 발생해야 한다.") {
        //given
        val lottoMachine = LottoMachine()
        listOf(1, 500, 900).forAll { purchaseAmount ->
            // when, then
            shouldThrow<RuntimeException> {
                lottoMachine.buyTickets(purchaseAmount)
            }
        }
    }

    test("로또 개수만큼 티켓을 발행할 수 있다.") {
        // given
        val lottoMachine = LottoMachine()
        val purchaseAmount = 14000
        val numberOfTickets = purchaseAmount / TICKET_PRICE

        // when
        val actual = lottoMachine.buyTickets(purchaseAmount)

        // then
        actual.numbers shouldHaveSize numberOfTickets
    }
})
