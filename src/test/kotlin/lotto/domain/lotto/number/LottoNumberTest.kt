package lotto.domain.lotto.number

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows

class LottoNumberTest : FunSpec({
    context("1~45 사이 숫자는 로또 번호 생성이 가능하다") {
        withData(
            (1..45)
        ) { number ->
            LottoNumber(number) shouldNotBe null
        }
    }

    context("1~45 범위 밖의 숫자는 로또 번호 생성이 불가능하다") {
        withData(
            ((-100..0) + (46..100))
        ) { invalidNumber ->
            assertThrows<IllegalArgumentException> {
                LottoNumber(invalidNumber)
            }
        }
    }
})
