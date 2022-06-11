package lotto.view

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoTicketNumber
import lotto.domain.Money
import lotto.util.InputModule
import lotto.util.OutPutModule

class BuyLottoInputViewTest : DescribeSpec({
    var outputStore = mutableListOf<String>()
    var stubOutputModule: OutPutModule = object : OutPutModule {
        override fun write(outputValue: String) {
            outputStore.add(outputValue)
        }
    }

    beforeEach {
        outputStore = mutableListOf<String>()
        stubOutputModule = object : OutPutModule {
            override fun write(outputValue: String) {
                outputStore.add(outputValue)
            }
        }
    }

    it("금액 입력을 위한 View String 을 내보낸다") {
        // given
        val stubInputModule: InputModule = object : InputModule {
            override fun read(): String {
                return "14000"
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

    it("수동으로 구매한 로또를 입력할수 있습니다") {
        // given
        val stubInputModule: InputModule = object : InputModule {
            val readStore = mutableListOf("3")
            override fun read(): String {
                return readStore.removeFirst()
            }
        }
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        buyLottoInputView.readPassiveTickets()

        // then
        outputStore[0] shouldBe "수동으로 구매할 로또 수를 입력해 주세요."
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
