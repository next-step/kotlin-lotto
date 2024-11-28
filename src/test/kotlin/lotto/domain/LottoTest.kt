package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.shouldBe
import lotto.strategy.WinningLottoNumberListGenerator
import lotto.stretagy.LottoNumberListGenerator

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        lateinit var lottoNumberListGenerator: LottoNumberListGenerator

        beforeTest { lottoNumberListGenerator = WinningLottoNumberListGenerator() }

        it("다른 숫자로 이루어진 6자리 로또를 생성한다") {
            val lottoNumbers = lottoNumberListGenerator.generate()
            val sut = Lotto.createLotto(lottoNumbers)
            sut.lottoNumbers.size shouldBe 6
        }

        it("로또의 각 숫자는 오름차순으로 정렬 되어 있어야 한다.") {
            val lottoNumbers = lottoNumberListGenerator.generate()
            val actual = Lotto.createLotto(lottoNumbers).lottoNumbers.toList()

            actual[0].number shouldBeLessThan actual[1].number
            actual[1].number shouldBeLessThan actual[2].number
            actual[2].number shouldBeLessThan actual[3].number
            actual[3].number shouldBeLessThan actual[4].number
            actual[4].number shouldBeLessThan actual[5].number
        }
    }
})
