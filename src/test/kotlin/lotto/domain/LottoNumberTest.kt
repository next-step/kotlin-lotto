package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoNumberTest : BehaviorSpec({

    given("로또의 숫자는 1부터 45까지의 숫자이다.") {
        `when`("로또의 숫자가 1~45 사이의 숫자일때") {
            val lottoNumber = LottoNumber(1)
            then("로또의 숫자를 반환한다.") {
                lottoNumber.number shouldBe 1
            }
        }
        `when`("로또의 숫자가 1~45 사이의 숫자가 아닐때") {
            val exception = shouldThrow<IllegalArgumentException> {
                LottoNumber(46)
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "로또 숫자는 1~45의 숫자만 가질 수 있습니다."
            }
        }
    }
})
