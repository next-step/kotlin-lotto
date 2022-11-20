package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize

class LottoGeneratorTest : StringSpec({

    val lottoGenerator = LottoGenerator(NumberGenerator())

    "로또 생성 개수 확인 테스트" {
        val inputSize = 24
        val resultLotto = lottoGenerator.generate(inputSize)
        resultLotto shouldHaveSize inputSize
    }
})
