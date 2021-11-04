package lotto.domain

import lotto.fixture.LottoNumbersFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun `두 개의 로또를 비교할 수 있다`() {
        // given
        val first = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_FIRST)
        val second = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_SECOND)

        // when
        val matches = first.compareTo(second)

        // then
        assertThat(matches).isEqualTo(5)
    }
}
