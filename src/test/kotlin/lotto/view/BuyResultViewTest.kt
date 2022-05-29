package lotto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lottery
import lotto.infra.port.OutputSystem

internal class BuyResultViewTest : BehaviorSpec({

    given("구매 결과 뷰는") {
        val lotteries =
            listOf(Lottery(listOf(1, 2, 3, 4, 5, 6)), Lottery(listOf(1, 2, 3, 4, 5, 6)), Lottery(listOf(1, 2, 3, 4, 5, 6)))
        val stubOutputSystem = StubOutputSystem()
        val buyResultView = BuyResultView(stubOutputSystem, lotteries)

        `when`("출력시") {
            buyResultView.printLottos()

            then("구매한 모든 로또의 리스트를 출력한다.") {
                val expected = """
                |3개를 구매했습니다.
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
