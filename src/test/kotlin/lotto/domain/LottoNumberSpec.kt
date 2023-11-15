package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberSpec : FunSpec({
    test("해당 숫자가 로또 번호에 포함되어 있는지 확인한다") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        forAll(
            row(1, true),
            row(2, true),
            row(3, true),
            row(4, true),
            row(5, true),
            row(6, true),
            row(7, false),
        ) { number, expect ->
            val result = LottoNumber(numbers) contains number

            result shouldBe expect
        }
    }

    test("두 로또 숫자에 공통으로 있는 숫자 개수가 계산된다") {
        val number1 = LottoNumber(listOf(1, 2, 3, 4, 5, 6))
        val number2 = LottoNumber(listOf(10, 9, 3, 2, 1, 8))

        val result = number1 countMatched number2

        result shouldBe 3
    }
})
