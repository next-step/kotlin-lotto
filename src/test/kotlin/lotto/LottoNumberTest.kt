package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : BehaviorSpec({

    Given("1 ~ 45 사이의 숫자가 주어지면") {
        val value = 1
        When("로또 번호는") {
            val lottoNumber = LottoNumber(value)
            Then("그 수를 가지는 로또번호가 생성된다.") {
                lottoNumber.value shouldBe value
            }
        }
    }

    Given("1 ~ 45 밖 숫자가 주어지면") {
        When("로또 번호는") {
            Then("에러를 발생한다.") {
                forAll(
                    row(-1),
                    row(0),
                    row(46),
                    row(47),
                ) { value ->
                    shouldThrow<IllegalArgumentException> {
                        LottoNumber(value)
                    }
                }
            }
        }
    }
})
