package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTest : BehaviorSpec({

    Given("서로 다른 6개의 숫자가 주어지면") {
        val lottoNumbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )
        When("로또는") {
            val lotto = Lotto(lottoNumbers)
            Then("그 수들을 가지는 로또가 생성된다.") {
                lotto.numbers.size shouldBe 6
            }
        }
    }

    Given("서로 다른 6개의 숫자가 아니라면") {
        When("로또는") {
            Then("에러를 발생한다.") {
                forAll(
                    row(listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5))),
                    row(
                        listOf(
                            LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5),
                            LottoNumber(6), LottoNumber(7)
                        )
                    ),
                    row(
                        listOf(
                            LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5),
                            LottoNumber(5)
                        )
                    ),
                ) { numbers ->
                    shouldThrow<IllegalArgumentException> {
                        Lotto(numbers)
                    }
                }
            }
        }
    }
})
