package lotto

import lotto.model.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `String 타입 숫자를 Int 숫자로 변환`() {
        val lottoNumber = LottoNumber("1")

        assertThat(lottoNumber.number).isEqualTo(1)
    }

    @Test
    fun `숫자 타입이 아닌 임의의 값을 전달하는 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber("+")
        }
    }

    @Test
    fun `로또 생성 범위에 속하지 않은 값을 입력한 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber("46")
        }
    }

    @Test
    fun `범위 내의 번호를 전달하는 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            LottoNumber(1_000)
        }
    }
}
