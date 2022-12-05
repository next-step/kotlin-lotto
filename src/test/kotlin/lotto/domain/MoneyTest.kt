package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

internal class MoneyTest {

    @Test
    fun `보유금액이 더 많은지 확인한다`() {
        // given
        val money = Money.of(1000)

        // when, then
        assertThat(money.hasMore(1200)).isFalse
        assertThat(money.hasMore(900)).isTrue
    }

    @Test
    fun `잔금이 남는지 확인한다`() {
        // given
        val money = Money.of(10000)

        // when, then
        assertAll(
            { assertThat(money.isNotChangeLeft(300)).isFalse },
            { assertThat(money.isNotChangeLeft(1500)).isFalse },
            { assertThat(money.isNotChangeLeft(1000)).isTrue },
            { assertThat(money.isNotChangeLeft(5000)).isTrue }
        )
    }

    @Test
    fun `금액이 사용된다`() {
        // given
        val money = Money.of(10000)

        // when
        val useMoney = money.useMoney(2000)

        // then
        assertThat(useMoney).isEqualTo(Money.of(8000))
    }
}
