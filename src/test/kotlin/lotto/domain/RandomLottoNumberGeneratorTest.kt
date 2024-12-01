package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange

class RandomLottoNumberGeneratorTest : FreeSpec({
    "6개의 숫자 목록을 생성한다" {
        val numbers = RandomLottoNumberGenerator.generate()

        numbers shouldHaveSize 6
        numbers.forEach { number ->
            number shouldBeInRange Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER
        }
    }
})
