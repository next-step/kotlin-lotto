package lotto

import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 47, 100])
    fun `1~45사이의 로또번호인지 확인`(number: Int) {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoNumber(number) }
            .withMessage("$number 는 로또 번호(1~45)가 아닙니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 12])
    fun `1~ 45 이외의 로또번호 확인`(number: Int) {
        Assertions.assertThat(LottoNumber(number)).isEqualTo(LottoNumber(number))
    }
}
