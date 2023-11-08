@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {
    @Test
    fun `번호 3개가 일치하면 당첨 금액은 5000원이다`() {
        val matchedNumberCount = 3

        val actual = Prize.valueOfOrNull(matchedNumberCount)
            ?.winningAmount

        assertThat(actual).isEqualTo(5000)
    }

    @Test
    fun `번호 4개가 일치하면 당첨 금액은 50000원이다`() {
        val matchedNumberCount = 4

        val actual = Prize.valueOfOrNull(matchedNumberCount)
            ?.winningAmount

        assertThat(actual).isEqualTo(50000)
    }

    @Test
    fun `번호 5개가 일치하면 당첨 금액은 1500000원이다`() {
        val matchedNumberCount = 5

        val actual = Prize.valueOfOrNull(matchedNumberCount)
            ?.winningAmount

        assertThat(actual).isEqualTo(1500000)
    }

    @Test
    fun `번호 6개가 일치하면 당첨 금액은 2000000000원이다`() {
        val matchedNumberCount = 6

        val actual = Prize.valueOfOrNull(matchedNumberCount)
            ?.winningAmount

        assertThat(actual).isEqualTo(2000000000)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `번호가 3개보다 적게 일치하면 당첨되지 않아 null을 반환한다`(matchedNumberCount: Int) {
        val actual = Prize.valueOfOrNull(matchedNumberCount)

        assertThat(actual).isNull()
    }
}
