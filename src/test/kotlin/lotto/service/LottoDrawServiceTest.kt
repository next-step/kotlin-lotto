@file:Suppress("NonAsciiCharacters")

package lotto.service

import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.domain.WinningStatistic
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class LottoDrawServiceTest {
    @Test
    fun `발급된 로또, 당첨 번호, 구입 금액이 주어지면 당첨 통계를 반환한다`() {
        val lotto1 = mockk<Lotto>()
        val lotto2 = mockk<Lotto>()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val purchaseAmount = 14000L

        val matchedNumberCount1 = 3
        val matchedNumberCount2 = 0
        every { lotto1.getMatchedNumberCount(any()) } returns matchedNumberCount1
        every { lotto2.getMatchedNumberCount(any()) } returns matchedNumberCount2

        val actual = LottoDrawService.draw(
            LottoDrawSpec(
                lottos = listOf(lotto1, lotto2),
                winningNumbers = winningNumbers,
                purchaseAmount = purchaseAmount,
            )
        )

        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(
                WinningStatistic(
                    prizes = listOf(Prize.valueOfOrNull(matchedNumberCount1)!!),
                    purchaseAmount = purchaseAmount,
                )
            )
    }
}
