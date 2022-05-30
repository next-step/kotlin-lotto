package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import lotto.util.InputModule
import lotto.util.OutPutModule

class BuyLottoInputViewTest : DescribeSpec({
    val stubInputModule: InputModule = mockk<InputModule>(relaxed = true)
    val stubOutputModule: OutPutModule = mockk<OutPutModule>(relaxed = true)

    it("금액 입력을 위한 View String 을 내보낸다") {
        // given
        every { stubInputModule.read() } returns "14000"
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        val readUserMoneyInput = buyLottoInputView.readUserMoneyInput()

        // then
        readUserMoneyInput.userMoney.value shouldBe 14000
        verify { stubOutputModule.write("구입금액을 입력해 주세요.") }
        verify { stubOutputModule.write("") }
    }

    it("당첨 번호 입력을 위한 View String 을 내보낸다") {
        // given
        every { stubInputModule.read() } returns "1, 2, 3, 4 ,5 ,6"
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        val winningNumbersInputDto = buyLottoInputView.readWinningLottoNumbers()

        // then
        winningNumbersInputDto.winningLottoTicketNumbers.value.map { it.value } shouldBe listOf(1, 2, 3, 4, 5, 6)
        verify { stubOutputModule.write("지난 주 당첨 번호를 입력해 주세요.") }
        verify { stubOutputModule.write("") }
    }
})
