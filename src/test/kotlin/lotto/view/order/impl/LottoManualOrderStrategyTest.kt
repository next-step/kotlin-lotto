package lotto.view.order.impl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.model.LottoGame

class LottoManualOrderStrategyTest : StringSpec({

    "수동으로 구매한 만큼 로또 게임이 만들어진다" {
        val actual = LottoManualOrderStrategy.manualIssue("1,2,3,4,5,6")

        actual.numbersIntersections(LottoGame(1, 2, 3, 4, 5, 6)) shouldBe 6
    }
})
