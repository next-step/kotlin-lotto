package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoNumbersGeneratorTest : DescribeSpec ({
    describe("로또 넘버 생성기 테스트") {
        it("1부터 45사이의 번호 중 6개를 임의로 선택할 수 있다.") {
            val lottoNumbers: List<Int> = LottoNumbersGenerator.generate()

            lottoNumbers.size shouldBe 6
            lottoNumbers.forEach { lottoNumber -> lottoNumber shouldBeInRange 1..45 }
        }
    }
})