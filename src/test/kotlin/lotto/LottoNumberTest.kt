package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `String 타입 숫자를 Int 숫자로 변환`() {
        val lottoNumber = LottoNumber("1")

        assertThat(lottoNumber.number).isEqualTo(1)
    }
}

class LottoNumber(val number: Int) {

    constructor(stringOfNumber: String) : this(stringOfNumber.toInt())
}
