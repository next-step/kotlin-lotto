package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoSpec : DescribeSpec({
    describe("로또 생성 검증") {
        context("로또를 생성하면") {
            val lotto = Lotto()

            it("로또는 6개의 번호를 갖고있다.") {
                lotto.numbers.values.size shouldBe 6
            }
        }
    }

    describe("로또 가격 검증") {
        it("로또의 가격은 1000원이다.") {
            Lotto.PRICE shouldBe 1000
        }
    }
})
