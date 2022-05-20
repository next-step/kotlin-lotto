package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import stringaddcalculator.lotto.Lotto

class LottoTest : DescribeSpec({

    describe("로또는") {
        it("로또 번호의 개수가 6개가 아니면 예외를 발생시킨다.") {
            val invalidLottoNumbers = listOf(
                listOf(1, 2, 3, 4, 5, 6, 7),
                listOf(1, 2, 3, 4, 5),
            )
            invalidLottoNumbers.forAll {
                shouldThrowExactly<IllegalArgumentException> {
                    Lotto.of(it)
                }
            }
        }

        context("다른 로또가 주어지면") {
            val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            val other = Lotto.of(listOf(1, 2, 3, 4, 44, 45))

            it("주어진 로또와 일치하는 로또 번호의 개수를 알 수 있다") {
                lotto.countMatchingNumbers(other) shouldBe 4
            }
        }
    }
})
