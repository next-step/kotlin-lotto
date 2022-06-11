package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class LottoManagerTest : FunSpec({
    test("로또 티켓과 당첨 번호를 비교하여, 3개가 매칭되는 경우 4등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTicketFixture.simpleLottoTicket()
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10, number2 = 11, number3 = 12)

        // when
        val result: LottoPrize = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbersTicket)

        // then
        result shouldBe LottoPrize.FOURTH_PLACE
    }

    test("로또 티켓과 당첨 번호를 비교하여, 4개가 매칭되는 경우 3등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTicketFixture.simpleLottoTicket()
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10, number2 = 11)

        // when
        val result: LottoPrize = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbersTicket)

        // then
        result shouldBe LottoPrize.THIRD_PLACE
    }

    test("로또 티켓과 당첨 번호를 비교하여, 5개가 매칭되는 경우 2등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTicketFixture.simpleLottoTicket()
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10)

        // when
        val result: LottoPrize = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbersTicket)

        // then
        result shouldBe LottoPrize.SECOND_PLACE
    }

    test("로또 티켓과 당첨 번호를 비교하여, 6개가 모두 매칭되는 경우 1등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTicketFixture.simpleLottoTicket()
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10)

        // when
        val result: LottoPrize = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbersTicket)

        // then
        result shouldBe LottoPrize.FIRST_PLACE
    }
})

object LottoTicketFixture {

    fun simpleLottoTicket(
        number1: Int = 1,
        number2: Int = 2,
        number3: Int = 3,
        number4: Int = 4,
        number5: Int = 5,
        number6: Int = 6,
    ): LottoTicket {
        return LottoTicket(
            setOf(
                LottoNumber(number1),
                LottoNumber(number2),
                LottoNumber(number3),
                LottoNumber(number4),
                LottoNumber(number5),
                LottoNumber(number6),
            )
        )
    }
}
