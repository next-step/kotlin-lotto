package lotto.domain

import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoResultTest {
    @Test
    fun `수익률을 계산한다`() {
        val payment = LottoPayment.from(14_000)
        val result =
            LottoResult.of(
                Rank.FOURTH to 1,
                Rank.FIFTH to 1,
                Rank.MISS to 12,
            )

        val roi = result.returnOnInvestment(payment)

        roi shouldBe (3.92857142857 plusOrMinus 1e-6)
    }
}
