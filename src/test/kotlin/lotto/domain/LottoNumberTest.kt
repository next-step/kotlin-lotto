package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 번호 - 범위(1~45) 초과에 대한 예외처리 테스트`(number: Int) {
        // when, then
        assertThatThrownBy { LottoNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 번호는 1~45 사이의 숫자만 가능합니다.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "Lotto"])
    fun `로또 번호 - 숫자 이외의 값 입력에 대한 예외처리 테스트`(input: String) {
        // given, when, then
        assertThatThrownBy { LottoNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("숫자 이외의 값은 입력할 수 없습니다.")
    }
}
