package lotto.domain

import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoResult2Test {
    @Test
    fun `수익률을 계산한다`() {
        val payment = LottoPayment.from(14_000)
        val result =
            LottoResult2.of(
                Rank2.FOURTH to 1,
                Rank2.FIFTH to 1,
                Rank2.MISS to 12,
            )

        val roi = result.returnOnInvestment(payment)

        roi shouldBe (3.92857142857 plusOrMinus 1e-6)
    }
}
