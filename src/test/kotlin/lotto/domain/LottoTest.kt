package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("서로 다른 6개의 숫자가 주어지면") {
        When("로또는") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            Then("그 수들을 가지는 로또가 생성된다.") {
                lotto.numbers.size shouldBe 6
            }
        }
    }

    Given("서로 다른 6개의 숫자가 아니라면") {
        When("로또는") {
            Then("에러를 발생한다.") {
                forAll(
                    row(listOf(1, 2, 3, 4, 5)),
                    row(listOf(1, 2, 3, 4, 5, 6, 7)),
                    row(listOf(1, 2, 3, 4, 5, 5)),
                ) { numbers ->
                    shouldThrow<IllegalArgumentException> {
                        Lotto(numbers)
                    }
                }
            }
        }
    }

    Given("다른 로또를 입력받으면") {
        val other = Lotto(1, 2, 3, 7, 8, 9)
        When("로또는") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            Then("겹치는 로또 번호가 몇 개인지 반환한다.") {
                lotto.matchCount(other) shouldBe 3
            }
        }
    }
})
