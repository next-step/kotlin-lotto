package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import lotto.domain.LottoNumberGenerator

class LottoNumberGeneratorTest : FunSpec({
    test("입력받은 개수만큼 1-45 사이의 무작위 수를 생성해서 반환한다.") {
        // given
        val lottoNumberGenerator = LottoNumberGenerator()
        val size = 6

        // when
        val actual = lottoNumberGenerator.generate()

        // then
        actual shouldHaveSize size
        actual.forAll {
            it shouldBeInRange (IntRange(1, 45))
        }
    }
})
