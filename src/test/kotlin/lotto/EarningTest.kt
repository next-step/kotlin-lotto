package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.Row2
import io.kotest.data.forAll
import io.kotest.matchers.shouldBe
import lotto.domain.Earning

class EarningTest: StringSpec({

    "정답 결과에 따라서 알맞은 수익이 발생해야한다" {
        val earning = Earning(mapOf(3 to 5000, 4 to 50000, 5 to 1500000, 6 to 2000000000))
        forAll(
            Row2(mapOf(3 to 1), 5000),
            Row2(mapOf(3 to 1, 4 to 2), 105000)
        ) { lottoResult, actual ->
            val result = earning.calculate(lottoResult)
            result shouldBe actual
        }
    }
})