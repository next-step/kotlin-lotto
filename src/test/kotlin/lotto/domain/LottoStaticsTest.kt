package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoStaticsTest {

    @DisplayName("구매 금액과 당첨금을 비교해서 수익률을 계산한다")
    @Test
    fun bep() {
        val amount = 14_000
        val prize = 5_000

        val result = LottoStatics().calculateEarningRate(prize, amount)

        result shouldBe 0.35f
    }
}
