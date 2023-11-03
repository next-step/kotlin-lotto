package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoNumberTest : FunSpec({

    test("로또의 숫자는 1부터 45까지의 숫자이다.") {
        val lottoNumber = LottoNumber((1..45).random())
        lottoNumber.number shouldBeInRange 1..45

        val exception = shouldThrow<IllegalArgumentException> {
            LottoNumber(46)
        }
        exception.message shouldBe "로또 숫자는 1~45의 숫자만 가질 수 있습니다."
    }
})
