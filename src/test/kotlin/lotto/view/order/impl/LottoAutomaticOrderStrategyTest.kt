package lotto.view.order.impl

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoAutomaticOrderStrategyTest : StringSpec({

    "자동으로 구매한 수량만큼 로또게임이 만들어진다" {
        val actual = LottoAutomaticOrderStrategy.issue(2)

        actual shouldHaveSize 2
    }
})
