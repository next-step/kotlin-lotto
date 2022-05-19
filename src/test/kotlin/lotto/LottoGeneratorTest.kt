package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import stringaddcalculator.lotto.FixedLottoGenerator
import stringaddcalculator.lotto.Lotto
import stringaddcalculator.lotto.RandomLottoGenerator

class LottoGeneratorTest : DescribeSpec({

    describe("랜덤 로또 생성기는") {
        it("로또를 생성한다") {
            val lottoGenerator = RandomLottoGenerator
            val lotto = lottoGenerator.generate()
            lotto.numbers.size shouldBe Lotto.SIZE_OF_LOTTO_NUMBERS
        }
    }

    describe("고정 로또 생성기는") {
        it("주어진 번호로 구성된 로또를 생성한다") {
            val lottoGenerator = FixedLottoGenerator(listOf(1, 2, 3, 4, 5, 6))
            val lotto = lottoGenerator.generate()
            lotto.numbers.size shouldBe Lotto.SIZE_OF_LOTTO_NUMBERS
        }
    }
})
