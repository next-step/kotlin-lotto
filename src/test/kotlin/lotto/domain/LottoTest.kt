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

    Given("로또 넘버를 입력받으면") {
        When("로또는") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            Then("그 숫자에 해당하는 로또 번호를 갖고 있는지 알려준다.") {
                forAll(
                    row(1, true),
                    row(2, true),
                    row(3, true),
                    row(4, true),
                    row(5, true),
                    row(6, true),
                    row(7, false),
                ) { number, expected ->
                    val lottoNumber = LottoNumber.from(number)
                    lotto.contains(lottoNumber) shouldBe expected
                }
            }
        }
    }

    Given("다른 로또가 입력으로 주어지면") {
        val other = Lotto(1, 2, 3, 7, 8, 9)
        When("로또는") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            Then("몇 개의 번호가 일치하는지를 반환한다.") {
                lotto.calculateMatchCount(other) shouldBe 3
            }
        }
    }
})
