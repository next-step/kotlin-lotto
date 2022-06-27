package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

internal class LottoManagerTest : FunSpec({
    test("로또 티켓과 당첨 번호를 비교하여, 3개가 매칭되는 경우 5등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTickets(listOf(LottoTicketFixture.simpleLottoTicket()))
        val winningNumbersTicket: LottoTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10, number2 = 11, number3 = 12)
        val bonusNumber: LottoNumber = LottoNumber.of(7)
        val winningNumbers = WinningNumbers(numbers = winningNumbersTicket, bonusNumber = bonusNumber)

        // when
        val result: LottoResults = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbers)

        // then
        result.fifthPlaceCount shouldBe 1
        result.forthPlaceCount shouldBe 0
        result.thirdPlaceCount shouldBe 0
        result.secondPlaceCount shouldBe 0
        result.firstPlaceCount shouldBe 0
    }

    test("로또 티켓과 당첨 번호를 비교하여, 4개가 매칭되는 경우 4등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTickets(listOf(LottoTicketFixture.simpleLottoTicket()))
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10, number2 = 11)
        val bonusNumber: LottoNumber = LottoNumber.of(7)
        val winningNumbers = WinningNumbers(numbers = winningNumbersTicket, bonusNumber = bonusNumber)

        // when
        val result: LottoResults = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbers)

        // then
        result.fifthPlaceCount shouldBe 0
        result.forthPlaceCount shouldBe 1
        result.thirdPlaceCount shouldBe 0
        result.secondPlaceCount shouldBe 0
        result.firstPlaceCount shouldBe 0
    }

    test("로또 티켓과 당첨 번호를 비교하여, 5개가 매칭되는 경우 3등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTickets(listOf(LottoTicketFixture.simpleLottoTicket()))
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10)
        val bonusNumber: LottoNumber = LottoNumber.of(7)
        val winningNumbers = WinningNumbers(numbers = winningNumbersTicket, bonusNumber = bonusNumber)

        // when
        val result: LottoResults = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbers)

        // then
        result.fifthPlaceCount shouldBe 0
        result.forthPlaceCount shouldBe 0
        result.thirdPlaceCount shouldBe 1
        result.secondPlaceCount shouldBe 0
        result.firstPlaceCount shouldBe 0
    }

    test("로또 티켓과 당첨 번호를 비교하여, 5개가 매칭되고 보너스 볼이 일치하는 경우 2등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTickets(listOf(LottoTicketFixture.simpleLottoTicket()))
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket(number1 = 10)
        val bonusNumber: LottoNumber = LottoNumber.of(1)
        val winningNumbers = WinningNumbers(numbers = winningNumbersTicket, bonusNumber = bonusNumber)

        // when
        val result: LottoResults = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbers)

        // then
        result.forthPlaceCount shouldBe 0
        result.thirdPlaceCount shouldBe 0
        result.secondPlaceCount shouldBe 1
        result.firstPlaceCount shouldBe 0
    }

    test("로또 티켓과 당첨 번호를 비교하여, 6개가 모두 매칭되는 경우 1등이 반환된다.") {
        // given
        val purchaseLottoTicket = LottoTickets(listOf(LottoTicketFixture.simpleLottoTicket()))
        val winningNumbersTicket = LottoTicketFixture.simpleLottoTicket()
        val bonusNumber: LottoNumber = LottoNumber.of(7)
        val winningNumbers = WinningNumbers(numbers = winningNumbersTicket, bonusNumber = bonusNumber)

        // when
        val result: LottoResults = LottoManager.winningConfirmation(purchaseLottoTicket, winningNumbers)

        // then
        result.forthPlaceCount shouldBe 0
        result.thirdPlaceCount shouldBe 0
        result.secondPlaceCount shouldBe 0
        result.firstPlaceCount shouldBe 1
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
                LottoNumber.of(number1),
                LottoNumber.of(number2),
                LottoNumber.of(number3),
                LottoNumber.of(number4),
                LottoNumber.of(number5),
                LottoNumber.of(number6),
            )
        )
    }
}
