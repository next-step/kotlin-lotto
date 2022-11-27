package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import lotto.util.RandomNumberGenerator

class LottoGeneratorTest : StringSpec({

    val lottoGenerator = LottoGenerator(RandomNumberGenerator())

    "로또 생성 개수 확인 테스트" {
        // given
        val inputSize = 24
        // when
        val resultLotto = lottoGenerator.generate(inputSize)
        // then
        resultLotto shouldHaveSize inputSize
    }
})
