package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : DescribeSpec({
    describe("로또 넘버 생성기 테스트") {
        it("1부터 45사이의 번호 중 6개를 임의로 가지는 로또 객체를 생성할 수 있다.") {
            val lotto: Lotto = LottoGenerator.generate()

            lotto.lottoNumbers.size shouldBe 6
        }
    }
})
