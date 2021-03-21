import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoNumberTest {
    @Test
    fun `로또 번호 숫자 범위에서는 정상적으로 객체가 생성된다`() {
        assertThat(LottoNumber(7).number).isEqualTo(7)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 60, 100])
    fun `로또 번호 숫자 범위 밖일 경우 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(number)
        }
    }
}
