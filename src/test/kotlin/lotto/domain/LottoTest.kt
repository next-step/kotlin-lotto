package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        it("1 ~ 45 사이의 숫자로 6자리 로또를 생성한다") {
            val actual = Lotto.generate()
            actual.size shouldBe 6
        }
    }
})
