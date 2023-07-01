package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class LottoNumberGeneratorTest : FunSpec({
    test("입력받은 개수만큼 1-45 사이의 무작위 수를 생성해서 반환한다.") {
        // given
        val lottoNumberGenerator = LottoNumberGenerator()
        val size = 6

        // when
        val actual = lottoNumberGenerator.generate()

        // then
        actual.values shouldHaveSize size
        actual.values.map { it.number }
            .forAll {
                it.shouldBeInRange(1..45)
            }
    }
})
