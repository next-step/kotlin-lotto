package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.model.LottoNumber

class LottoNumberTest : StringSpec({

    "1 ~ 45 숫자를 생성할 수 있어야 한다." {
        val validNumbers = listOf(1, 23, 45)
        validNumbers.forEach { num ->
            val lottoNumber = LottoNumber(num)
            lottoNumber.num shouldBe num
        }
    }

    "음수는 예외를 던진다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumber(0)
            }
        exception.message shouldBe "로또 숫자 범위는 1에서 45까지 입니다."
    }

    "45를 넘는 숫자는 예외를 던진다." {
        val exception =
            shouldThrow<IllegalArgumentException> {
                LottoNumber(46)
            }
        exception.message shouldBe "로또 숫자 범위는 1에서 45까지 입니다."
    }

    "동일한 숫자로 비교될 때 같은 객체로 간주되어야 한다" {
        val lottoNumber1 = LottoNumber(10)
        val lottoNumber2 = LottoNumber(10)
        lottoNumber1 shouldBe lottoNumber2
    }
})
