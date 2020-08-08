package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `String 타입 숫자를 Int 숫자로 변환`() {
        val lottoNumber = LottoNumber("1")

        assertThat(lottoNumber.number).isEqualTo(1)
    }

    @Test
    fun `숫자 타입이 아닌 임의의 값을 전달하는 경우`() {
    }
}

class LottoNumber(val number: Int) {

    constructor(stringOfNumber: String) : this(stringOfNumber.toInt())
}
