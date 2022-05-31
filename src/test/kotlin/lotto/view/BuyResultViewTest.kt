package lotto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.NormalLottery
import lotto.infra.port.OutputSystem
import lotto.vo.LotteryNumber
import lotto.vo.LottoSet

internal class BuyResultViewTest : BehaviorSpec({

    given("구매 결과 뷰는") {
        val lotteries =
            LottoSet(
                listOf(
                    NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of)),
                    NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of)),
                    NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of))
                )
            )
        val stubOutputSystem = StubOutputSystem()
        val buyResultView = BuyResultView(stubOutputSystem, lotteries)

        `when`("출력시") {
            buyResultView.printLotteries()

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
