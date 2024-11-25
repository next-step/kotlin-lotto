package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

@Suppress("NonAsciiCharacters")
class LottoTest {
    @Test
    fun `당첨 통계를 계산한다`() {
        val lotto =
            Lotto.from(
                // FIRST
                LottoLine.from(1, 2, 3, 4, 5, 6),
                // SECOND
                LottoLine.from(1, 2, 3, 4, 5, 7),
                // THIRD
                LottoLine.from(1, 2, 3, 4, 5, 8),
                // FOURTH
                LottoLine.from(1, 2, 3, 4, 8, 9),
                // FIFTH
                LottoLine.from(1, 2, 3, 8, 9, 10),
                // MISS
                LottoLine.from(1, 2, 8, 9, 10, 11),
                LottoLine.from(1, 8, 9, 10, 11, 12),
            )
        val winner =
            WinningLine(
                LottoLine.from(1, 2, 3, 4, 5, 6),
                LottoNumber.from(7),
            )

        val result = lotto.match(winner)

        val expected =
            LottoResult.of(
                Rank.FIRST to 1,
                Rank.SECOND to 1,
                Rank.THIRD to 1,
                Rank.FOURTH to 1,
                Rank.FIFTH to 1,
                Rank.MISS to 2,
            )

        result shouldBe expected
    }
}
