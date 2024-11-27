package lotto.domain

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
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

        val result = lotto.match2(winner)

        val expected =
            LottoResult2.of(
                Rank2.FIRST to 1,
                Rank2.SECOND to 1,
                Rank2.THIRD to 1,
                Rank2.FOURTH to 1,
                Rank2.FIFTH to 1,
                Rank2.MISS to 2,
            )

        result shouldBe expected
    }

    @Test
    fun `두 로또를 통합한다`() {
        val lines =
            listOf(
                LottoLine.from(1, 2, 3, 4, 5, 6),
                LottoLine.from(2, 3, 4, 5, 6, 7),
                LottoLine.from(3, 4, 5, 6, 7, 8),
            )
        val lotto1 = Lotto.from(lines[0])
        val lotto2 = Lotto.from(lines[1], lines[2])

        val actual: Lotto = lotto1.merge(lotto2)

        actual.lines shouldContainExactlyInAnyOrder lines
    }
}
