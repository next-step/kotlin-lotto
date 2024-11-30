package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomLottoNumberGeneratorTest : FreeSpec({
    "6개의 숫자 목록을 생성한다" {
        val numbers = RandomLottoNumberGenerator.generate()

        numbers shouldHaveSize 6
        numbers.forEach { number ->
            number shouldBeInRange Lotto.MIN_LOTTO_NUMBER..Lotto.MAX_LOTTO_NUMBER
        }
    }
})
