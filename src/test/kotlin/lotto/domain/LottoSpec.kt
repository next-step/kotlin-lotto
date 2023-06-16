package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSpec : DescribeSpec({
    describe("로또 생성") {
        context("로또를 생성하면") {
            it("로또는 6개의 번호를 갖고있다.") {
                val lotto = Lotto()

                lotto.numbers.size shouldBe 6
            }
        }
    }

    describe("매치되는 번호 개수 계산") {
        context("로또와 번호 목록이 주어지면") {
            val numbers = listOf(1, 2, 3, 4, 5, 6)
            val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))

            it("매치되는 번호 개수를 계산한다.") {
                val numberOfMatchedNumbers = lotto.calculateNumberOfMatchedNumbers(numbers)

                numberOfMatchedNumbers shouldBe 6
            }
        }
    }
})
