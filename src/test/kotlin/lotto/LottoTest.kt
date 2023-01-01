package lotto

import io.kotest.core.spec.style.StringSpec
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import org.assertj.core.api.Assertions

class LottoTest : StringSpec({

    "로또 하나의 숫자는 6개 이다" {
        val numbers = (1..7).map { LottoNumber(it) }

        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lotto(numbers.toSet()) }
    }
})
