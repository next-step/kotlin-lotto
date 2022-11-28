package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersTest : DescribeSpec ({
    describe("로또 넘버 테스트") {
        it("생성된 로또 번호를 정렬할 수 있다.") {
            val lottoNumbers = LottoNumbers(listOf(1, 3, 2, 5, 4))
            val sortedLottoNumbers = lottoNumbers.sort()

            sortedLottoNumbers shouldBe listOf(1, 2, 3, 4, 5)
        }
    }
})