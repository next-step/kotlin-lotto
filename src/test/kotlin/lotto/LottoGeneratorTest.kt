package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import stringaddcalculator.lotto.Lotto
import stringaddcalculator.lotto.RandomLottoGenerator

class LottoGeneratorTest : DescribeSpec({

    describe("로또 생성기는") {
        it("로또를 생성한다") {
            val lottoGenerator = RandomLottoGenerator
            val lotto = lottoGenerator.generate()
            lotto.numbers.size shouldBe Lotto.SIZE_OF_LOTTO_NUMBERS
        }
    }
})
