package lotto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.domain.LotterySet
import lotto.domain.toLotteryNumberSet
import lotto.dto.BuyLotteriesDTO
import lotto.infra.port.OutputSystem

internal class BuyResultViewTest : BehaviorSpec({

    given("구매 결과 뷰는") {
        val lotteries =
            LotterySet(
                listOf(
                    Lottery(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()),
                    Lottery(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()),
                    Lottery(listOf(1, 2, 3, 4, 5, 6).toLotteryNumberSet()),
                )
            )
        val stubOutputSystem = StubOutputSystem()
        val buyResultView = BuyResultView(stubOutputSystem)

        `when`("출력시") {
            val dto = BuyLotteriesDTO(lotteries, lotteries)

            buyResultView.printLotteries(dto)

            then("구매한 모든 로또의 리스트를 출력한다.") {
                val expected = """
                |수동 3개, 자동 3개를 구매했습니다.
                |[1, 2, 3, 4, 5, 6]
                |[1, 2, 3, 4, 5, 6]
                |[1, 2, 3, 4, 5, 6]
                |[1, 2, 3, 4, 5, 6]
                |[1, 2, 3, 4, 5, 6]
                |[1, 2, 3, 4, 5, 6]
                |
                """.trimMargin()
                stubOutputSystem.screenBuffer.joinToString("") shouldBe expected
            }
        }
    }
})

class StubOutputSystem : OutputSystem {

    val screenBuffer = mutableListOf<String>()

    override fun write(content: String) {
        screenBuffer += content
    }
}
