package lotto.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.comparables.shouldBeLessThan
import io.kotest.matchers.shouldBe

class LottoNumberGeneratorTest : FunSpec({
    val lottoNumberGenerator = LottoNumberGenerator()

    test("로또 번호 생성 시 6자리 번호가 포함되어있는 경우 성공") {
        val result = lottoNumberGenerator.generate()

        result.size shouldBe LottoNumberGenerator.LOTTO_NUMBER_LENGTH
    }

    test("로또 번호 생성 시 정렬되어있는 경우 성공") {
        val result = lottoNumberGenerator.generate()

        result.windowed(2, 1)
            .forEach {
                val firstNumber = it[0]
                val secondNumber = it[1]

                firstNumber shouldBeLessThan secondNumber
            }
    }
})
