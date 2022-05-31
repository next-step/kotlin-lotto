package lotto.view

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.domain.NormalLottery
import lotto.vo.LotteryNumber
import lotto.vo.LotteryRank

internal class InputLastWeekLottoViewTest : BehaviorSpec({

    given("InputLastWeekLottoView는") {
        val stubIOSystem = StubIOSystem("1, 2, 3, 4, 5, 6")
        val inputLastWeekLottoView = InputLastWeekLottoView(stubIOSystem)

        `when`("호출시") {
            val result = inputLastWeekLottoView.getLastWeekLotto()

            then("입력 안내문과 지난주 당첨 로또 번호를 반환한다.")
            val expectedNormalLottery = NormalLottery(listOf(1, 2, 3, 4, 5, 6).map(LotteryNumber::of))
            stubIOSystem.screenBuffer.first() shouldBe "지난 주 당첨 번호를 입력해 주세요.\n"
            result.match(expectedNormalLottery) shouldBe LotteryRank.ONE_PLACE
        }
    }
})
