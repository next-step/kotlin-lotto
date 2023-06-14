package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RevenueTest : StringSpec({

    "수익 객체를 통해 수익률을 계산할 수 있다." {
        forAll(
            row(2.0, 2.0, 1.0),
            row(13.0, 15.0, 0.8666666666666667),
            row(222.0, 244.0, 0.9098360655737705),
            row(432.0, 0.0, 0.0),
            row(0.0, 27278.0, 0.0),
        ) { proceeds, purchasedPrice, expect ->
            val revenue = Revenue(proceeds = proceeds, purchasedPrice = purchasedPrice)

            revenue.rateOfReturn shouldBe expect
        }
    }
})
