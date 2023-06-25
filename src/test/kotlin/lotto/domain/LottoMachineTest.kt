package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.LottoNumbers.Companion.toNumbers
import lotto.fake.FakeNumberGenerator

class LottoMachineTest : FunSpec({
    test("구입 금액을 입력하면 구입 금액에 해당하는 로또 개수를 반환한다.") {
        // given
        val lottoMachine = LottoMachine()
        val purchaseAmount = 14000
        val expected = 14

        // when
        val lottoTickets = lottoMachine.buyTickets(purchaseAmount)

        // then
        lottoTickets.values shouldHaveSize expected
    }

    test("로또 1장의 가격(1000)보다 구입 금액이 적다면 IllegalArgumentException 예외가 발생해야 한다.") {
        // given
        val lottoMachine = LottoMachine()
        listOf(1, 500, 900).forAll { purchaseAmount ->
            // when, then
            shouldThrow<IllegalArgumentException> {
                lottoMachine.buyTickets(purchaseAmount)
            }.also {
                it.message shouldBe "최소 구매 금액은 1000원 입니다. 입력 구매 금액: [$purchaseAmount]"
            }
        }
    }

    test("로또 숫자 개수에 맞는 숫자를 생성해 티켓을 발행할 수 있다.") {
        // given
        val expected = listOf(1, 2, 3, 4, 5, 6)
        val lottoMachine = LottoMachine(FakeNumberGenerator(expected))
        val purchaseAmount = 1000
        val numberOfTickets = 1

        // when
        val actual = lottoMachine.buyTickets(purchaseAmount)

        // then
        actual.values shouldHaveSize numberOfTickets
        actual.values[0] shouldBe expected.toNumbers()
    }
})
