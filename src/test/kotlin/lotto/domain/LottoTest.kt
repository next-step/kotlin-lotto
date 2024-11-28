package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        it("로또를 생성할 개수를 받아 로또를 생성한다") {
            val sut = Lotto.generate(10)
            sut.size shouldBe 10
        }

        it("다른 숫자로 이루어진 6자리 로또를 생성한다") {
            val actual = Lotto.generate(1)
            val lotto: Lotto = actual[0]
            lotto.lottoNumbers.size shouldBe 6
        }

        it("로또의 각 숫자는 오름차순으로 정렬 되어 있어야 한다.") {
            val lotto = Lotto.generate(1)[0]
            val lottoNumbers = lotto.lottoNumbers.toList()

            lottoNumbers.size shouldBe 6
            lottoNumbers shouldBe lottoNumbers.sortedBy { it.number }
        }
    }
})
