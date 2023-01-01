package com.nextstep.lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoBallTest : BehaviorSpec({

    Given("LottoBall 을 생성할 때") {
        When("전달받은 숫자가 1~45 사이이면") {
            Then("LottoBall이 생성된다.") {
                forAll(
                    row(1),
                    row(45)
                ) { number ->
                    shouldNotThrowAny { LottoNumber(number) }
                }
            }
        }
        When("전달받은 숫자가 1보다 작거나 45보다 크면") {
            Then("IllegalArgumentException이 발생한다.") {
                forAll(
                    row(-1),
                    row(0),
                    row(46)
                ) { number ->
                    shouldThrow<IllegalArgumentException> { LottoNumber(number) } shouldHaveMessage
                            "로또 번호는 1에서 45 사이의 숫자여야 합니다. number: $number"
                }
            }
        }
    }
})
