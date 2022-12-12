package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber

class LottoTest : StringSpec({

    "로또 번호가 6개를 넘으면 에러 발생 테스트" {
        val numbers = listOf(
            LottoNumber(IntegerNumber(1)),
            LottoNumber(IntegerNumber(2)),
            LottoNumber(IntegerNumber(3)),
            LottoNumber(IntegerNumber(4)),
            LottoNumber(IntegerNumber(5)),
            LottoNumber(IntegerNumber(6)),
            LottoNumber(IntegerNumber(7))
        )
        val exception = shouldThrowExactly<IllegalArgumentException> {
            Lotto(numbers)
        }
        exception.message shouldBe "로또 번호는 6개가 필요합니다."
    }
})
