package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoNumberTest : BehaviorSpec({
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
