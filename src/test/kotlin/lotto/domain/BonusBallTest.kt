package lotto.domain

import lotto.fixture.LottoNumbersFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BonusBallTest {

    @ParameterizedTest
    @CsvSource(value = ["1,true", "5,true", "11,true", "45,false"])
    fun `보너스 볼이 로또 번호에 포함되었는지 확인할 수 있다`(value: Int, expect: Boolean) {
        // given
        val lottoNumbers = LottoNumbersFixture.LOTTO_NUMBER_SET_WINNING
        val bonusBall = BonusBall.of(value)

        // then
        assertThat(bonusBall.isIn(lottoNumbers)).isEqualTo(expect)
    }
}
