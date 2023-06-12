package lotto.domain.generator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.comparables.shouldBeLessThan

class RandomLottoNumbersGeneratorTest : FunSpec({
    val lottoNumberGenerator = RandomLottoNumbersGenerator

    test("중복되지 않는 6개의 로또 번호 목록을 반환한다.") {
        val actual = lottoNumberGenerator.generate()

        actual shouldHaveSize 6
        actual.toSet() shouldHaveSize 6
    }

    test("로또 번호는 오름차순 정렬되어 있다.") {
        val lottoNumbers = lottoNumberGenerator.generate()

        lottoNumbers.forEachIndexed { index, sourceNumber ->
            val actual = lottoNumbers.subList(index + 1, lottoNumbers.size)

            actual.forEach { targetNumber ->
                sourceNumber.number shouldBeLessThan targetNumber.number
            }
        }
    }
})
