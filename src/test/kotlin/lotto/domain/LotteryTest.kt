package lotto.domain

import lotto.fixture.LottoNumberFixture
import lotto.fixture.LottoNumbersFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class LotteryTest {

    @Test
    fun `두 개의 로또를 비교할 수 있다`() {
        // given
        val first = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_FIRST)
        val second = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_SECOND)

        // when
        val matches = first.drawLottery(second)

        // then
        assertThat(matches).isEqualTo(5)
    }

    @Test
    fun `보너스 볼 번호를 포함하고 있는지 확인할 수 있다`() {
        // given
        val first = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_FIRST)
        val second = Lottery.of(LottoNumbersFixture.LOTTO_NUMBER_SET_SECOND)
        val bonusBall = LottoNumberFixture.BONUS_BALL

        // then
        assertAll(
            { assertThat(first.isContainBall(bonusBall)).isFalse },
            { assertThat(second.isContainBall(bonusBall)).isTrue }
        )
    }
}
