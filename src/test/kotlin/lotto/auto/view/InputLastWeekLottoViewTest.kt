package lotto.auto.view

import io.kotest.core.spec.style.BehaviorSpec
import lotto.auto.domain.Lotto
import lotto.auto.vo.LottoScore

internal class InputLastWeekLottoViewTest : BehaviorSpec({

    given("InputLastWeekLottoView는") {
        val stubIOSystem = StubIOSystem("1, 2, 3, 4, 5, 6")
        val inputLastWeekLottoView = InputLastWeekLottoView(stubIOSystem)

        `when`("호출시") {
            val result = inputLastWeekLottoView.getLastWeekLotto()

            then("지난주 당첨 로또 번호를 반환한다.")
            val expectedLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
            result.match(expectedLotto) shouldBe LottoScore.ONE_PLACE
        }
    }
})
