package lotto

import io.kotest.core.spec.style.StringSpec
import lotto.domain.StringNumbers
import org.assertj.core.api.Assertions

class StringNumbersTest : StringSpec({

    "입력 문자열을 통해서 구분자를 통해서 변환한 문자열 리스트 유효성 검사" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringNumbers("") }
    }
})
