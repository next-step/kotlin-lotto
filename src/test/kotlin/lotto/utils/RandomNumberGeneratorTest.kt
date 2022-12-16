package lotto.utils

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.ints.shouldBeInRange

internal class RandomNumberGeneratorTest : StringSpec({
    "일정 범위안의 랜덤값을 생성할 수 있다." {
        RandomNumberGenerator.generate(1..45) shouldBeInRange (1..45)
    }
})
