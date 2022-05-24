package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : StringSpec({

    "로또 번호는 6개의 숫자를 가지고 있다" {
        val lottoNumber = LottoNumber(numbers = listOf(1, 2, 3, 4, 5, 6))
        lottoNumber.numbers.size shouldBe 6
    }

    "로또 번호는 6개 이하의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoNumber(listOf(1))
        }
    }

    "로또 번호는 6개 이상의 숫자를 입력하게 되면 IllegalArgumentException을 발생한다" {
        shouldThrowExactly<IllegalArgumentException> {
            LottoNumber(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }
})
