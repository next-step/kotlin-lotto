package lotto.view.order.impl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.model.LottoGame

class LottoManualOrderStrategyTest : StringSpec({

    "수동으로 입력한 문자열에 맞는 로또 게임이 만들어져야 한다" {
        val actual = LottoManualOrderStrategy.manualIssue("1,2,3,4,5,6")

        actual.numbersIntersections(LottoGame(1, 2, 3, 4, 5, 6)) shouldBe 6
    }
})
