package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketNumber
import lotto.domain.Money
import lotto.util.InputModule
import lotto.util.OutPutModule

class BuyLottoInputViewTest : DescribeSpec({

    it("금액 입력을 위한 View String 을 내보낸다") {
        // given
        val stubInputModule: InputModule = object : InputModule {
            override fun read(): String {
                return "14000"
            }
        }
        val outputStore = mutableListOf<String>()
        val stubOutputModule = object : OutPutModule {
            override fun write(outputValue: String) {
                outputStore.add(outputValue)
            }
        }
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        val userMoney = buyLottoInputView.readUserMoneyInput()

        // then
        userMoney shouldBe Money(14000)
        outputStore[0] shouldBe "구입금액을 입력해 주세요."
        outputStore[1] shouldBe ""
    }

    it("당첨 번호 입력을 위한 View String 을 내보낸다") {
        // given
        val stubInputModule: InputModule = object : InputModule {
            val readStore = mutableListOf("1, 2, 3, 4 ,5 ,6", "7")
            override fun read(): String {
                return readStore.removeFirst()
            }
        }
        val outputStore = mutableListOf<String>()
        val stubOutputModule = object : OutPutModule {
            override fun write(outputValue: String) {
                outputStore.add(outputValue)
            }
        }
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        val winningLottoTicketNumbers = buyLottoInputView.readWinningLottoNumbers()

        // then
        winningLottoTicketNumbers.winningLottoNumbers.value.map { it.value } shouldBe listOf(
            1,
            2,
            3,
            4,
            5,
            6
        )
        winningLottoTicketNumbers.bonusLottoNumber shouldBe LottoTicketNumber(7)
        outputStore[0] shouldBe "지난 주 당첨 번호를 입력해 주세요."
        outputStore[1] shouldBe "보너스 볼을 입력해 주세요."
        outputStore[2] shouldBe ""
    }
})
