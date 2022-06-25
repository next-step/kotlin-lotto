package lotto.view

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.toLotteryNumberSet
import lotto.dto.OrderLotteryRequestDTO
import lotto.infra.port.IOSystem
import lotto.vo.Money

internal class InputMoneyViewTest : StringSpec({

    "입력 뷰는 보유 금액과 수동 로또 수량을 입력받아 반환한다." {
        val view = InputMoneyView(StubIOSystem(listOf("1000", "1", "1,2,3,4,5,6")))

        val result = view.orderLottery()

        result shouldBe OrderLotteryRequestDTO(Money(1000), listOf(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()), 0)
    }
})

class StubIOSystem(private val inputMoney: List<String>) : IOSystem {

    val screenBuffer = mutableListOf<String>()
    private var index = 0

    override fun read(): String = inputMoney[index++ % inputMoney.size]

    override fun write(content: String) {
        screenBuffer += content
    }
}
