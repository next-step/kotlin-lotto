package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

class LottoNumberTest : BehaviorSpec({
    Given("로또 넘버") {
        When("46 번호로 생성 했을 때") {
            Then("에러가 난다") {
                shouldThrow<IllegalArgumentException> { LottoNumber.from(46) }
            }
        }
    }
})
