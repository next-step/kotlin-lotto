package lotto

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions

class LottoNumberTest : StringSpec({

    "로또 숫자는 1-45 사이 이다" {

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { LottoNumber(50) }
    }
})
