package lotto.domain

import lotto.fixture.WinningLotteryFixture
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusBallTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6])
    fun `보너스 볼은 당첨번호에 포함될 수 없다`(value: Int) {
        // given
        val winning = WinningLotteryFixture.WINNING_LOTTERY

        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { BonusBall.of(winning, LottoNumber.of(value)) }
    }
}
