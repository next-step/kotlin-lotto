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
            val readStore = mutableListOf(
                "3",
                "8, 21, 23, 41, 42, 43",
                "3, 5, 11, 16, 32, 38",
                "7, 11, 16, 35, 36, 44"
            )

            override fun read(): String {
                return readStore.removeFirst()
            }
        }
        val buyLottoInputView = BuyLottoInputView(stubInputModule, stubOutputModule)

        // when
        val readPassiveTickets = buyLottoInputView.readPassiveTickets()

        // then
        outputStore[0] shouldBe "수동으로 구매할 로또 수를 입력해 주세요."
        outputStore[1] shouldBe ""
        outputStore[2] shouldBe "수동으로 구매할 번호를 입력해 주세요."
        outputStore[3] shouldBe ""
        readPassiveTickets[0].lottoTicketNumbers.value.map { it.value } shouldBe listOf(8, 21, 23, 41, 42, 43)
        readPassiveTickets[1].lottoTicketNumbers.value.map { it.value } shouldBe listOf(3, 5, 11, 16, 32, 38)
        readPassiveTickets[2].lottoTicketNumbers.value.map { it.value } shouldBe listOf(7, 11, 16, 35, 36, 44)
    }

    it("수동으로 구매한 로또가 없는 경우 넘어간다") {
        // given
        val stubInputModule: InputModule = object : InputModule {
            val readStore = mutableListOf(
                "0"
            )

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
        outputStore.size shouldBe 2
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
            1, 2, 3, 4, 5, 6
        )
        winningLottoTicketNumbers.bonusLottoNumber shouldBe LottoTicketNumber(7)
        outputStore[0] shouldBe "지난 주 당첨 번호를 입력해 주세요."
        outputStore[1] shouldBe "보너스 볼을 입력해 주세요."
        outputStore[2] shouldBe ""
    }
})
