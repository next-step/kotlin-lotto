package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoBallTest : StringSpec({
    "로또 번호는 1부터 45 사이여야 합니다." {
        forAll(
            row(0),
            row(46),
        ) { ballNumber ->
            val exception = shouldThrowExactly<IllegalArgumentException> { LottoBall(ballNumber) }
            exception.message shouldBe "로또 번호는 1부터 45 사이여야 합니다."
        }
    }
})
