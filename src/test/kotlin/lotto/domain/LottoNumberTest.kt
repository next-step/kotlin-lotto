package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoNumberTest : FunSpec({

    context("LottoNumber 정상 생성") {
        withData(
            nameFn = { "LottoNumber(number = $it)" },
            1, 2, 10, 20, 45,
        ) { number ->
            LottoNumber(number = number).number shouldBe number
        }
    }

    context("LottoNumber 범위를 벗어나면 IllegalArgumentException throw") {
        withData(
            nameFn = { "LottoNumber(number = $it)" },
            -1, 0, 46, 47, 100
        ) { number ->
            shouldThrow<IllegalArgumentException> {
                LottoNumber(number = number)
            }
        }
    }

    test("LottoNumber는 equals 비교가 가능하다.") {
        val number1 = 1
        val number2 = 10

        (LottoNumber(number1) == LottoNumber(number1)) shouldBe true
        (LottoNumber(number2) == LottoNumber(number2)) shouldBe true
        (LottoNumber(number1) == LottoNumber(number2)) shouldBe false
    }
})
