package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "45"])
    fun `로또 번호는 1 이상 45 이하이다`(input: String) {
        assertThat(LottoNumber.of(input.toInt()).number).isEqualTo(input.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1,0,1,2,3,4", "1,2,3,4,5,46"])
    fun `당첨번호에 1 미만 45 초과 값이 들어가면 예외가 발생한다`(input: String) {
        Assertions.assertThatThrownBy {
            LottoCommittee.createWinningTicket(input, "7")
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호가 유효 범위내에 있지 않습니다.")
    }
}
