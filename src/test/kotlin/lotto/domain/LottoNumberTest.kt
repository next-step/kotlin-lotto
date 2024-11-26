package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : BehaviorSpec({
    Given("유효한 로또 번호가 주어졌을 때") {
        forAll(
            row(1),
            row(23),
            row(45),
        ) { validNumber ->
            When("로또 번호를 생성하면") {
                val lottoNumber = LottoNumber(validNumber)

                Then("로또 번호 객체가 정상적으로 생성된다") {
                    lottoNumber.value shouldBe validNumber
                }
            }
        }
    }

    Given("로또 번호가 주어졌을 때") {
        forAll(
            row(0),
            row(46),
            row(-5),
        ) { lottoNumber ->
            When("번호가 범위를 벗어난 경우") {
                Then("예외가 발생한다") {
                    shouldThrow<IllegalArgumentException> { LottoNumber(lottoNumber) }
                        .message shouldBe "로또 번호는 1부터 45 사이여야 합니다."
                }
            }
        }
    }
})
