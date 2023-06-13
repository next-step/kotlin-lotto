package lotto.domain.generator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize

class RandomLottoNumbersGeneratorTest : FunSpec({
    val lottoNumberGenerator = RandomLottoNumbersGenerator

    test("중복되지 않는 6개의 로또 번호 목록을 반환한다.") {
        val actual = lottoNumberGenerator.generate()

        actual shouldHaveSize 6
        actual.toSet() shouldHaveSize 6
    }
})
