package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        it("다른 숫자로 이루어진 6자리 로또를 생성한다") {
            val actual = Lotto.generate()
            actual.size shouldBe 6
        }
    }
})
