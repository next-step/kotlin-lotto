package lotto

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
    }
}

class LottoNumber(val number: Int) {

    constructor(stringOfNumber: String) : this(convertTo(stringOfNumber))

    companion object {
        private val IS_NUMBER_REGEX = "(^[0-9]*\$)".toRegex()

        fun convertTo(stringOfNumber: String): Int {
            require(stringOfNumber.matches(IS_NUMBER_REGEX)) {
                "숫자 이외의 값이 입력되었습니다."
            }
            return stringOfNumber.toInt()
        }
    }
}
