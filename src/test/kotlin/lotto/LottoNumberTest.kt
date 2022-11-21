package lotto

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.checkAll
import lotto.domain.LottoNumber
import lotto.util.ExceptionMessage

internal class LottoNumberTest : StringSpec({
    "1번부터 45번 사이의 숫자는 정상적으로 로또 번호가 생성된다." {
        checkAll(Arb.int(1..45)) { number ->
            shouldNotThrowAny {
                LottoNumber(number)
            }
        }
    }

    "1번부터 45번 이외의 숫자는 예외를 던진다." {
        checkAll(Arb.int(46..100)) { number ->
            val exception = shouldThrow<IllegalArgumentException> {
                LottoNumber(number)
            }
            exception.message shouldBe ExceptionMessage.LOTTO_NUMBER_ERROR
        }
    }
})
