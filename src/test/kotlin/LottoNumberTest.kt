import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class LottoNumberTest {
    @Test
    fun `로또 숫자의 범위는 1 ~ 45 까지만 허용된다`() {
        // given
        // when
        // then
        (1..45).forEach {
            assertThat(LottoNumber(it).number).isEqualTo(it)
        }
    }

    @Test
    fun `1 ~ 45 범위 이외에 로또번호는 생성될 수 없다`() {
        // given

        // when

        // then
        assertThrows<RuntimeException> {
            LottoNumber(0).number
        }
    }
}
