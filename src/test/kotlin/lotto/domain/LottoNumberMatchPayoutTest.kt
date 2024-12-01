package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberMatchPayoutTest {
    @ParameterizedTest
    @CsvSource(
        "0, 0",
        "1, 0",
        "2, 0",
        "3, 5000",
        "4, 50000",
        "5, 1500000",
        "6, 2000000000",
    )
    fun `로또 당첨 번호 매칭 개수에 따른 당첨 금액을 확인한다`(
        matchCount: Int,
        payout: Int,
    ) {
        LottoNumberMatchPayout.byMatchCount(matchCount = matchCount).matchCountPayout shouldBe payout
    }
}
