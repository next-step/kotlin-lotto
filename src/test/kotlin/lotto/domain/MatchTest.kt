package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MatchTest {

    @ParameterizedTest
    @CsvSource(value = ["3,5_000", "4,50_000", "5,1_500_000", "6,2_000_000_000"])
    fun `당첨 개수를 받아 당첨 금액을 반환한다`(count: Int, winningAmount: Int) {
        val match = Match.from(count)

        match?.winningAmount shouldBe winningAmount
    }
}
