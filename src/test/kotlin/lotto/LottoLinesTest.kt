package lotto

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoLinesTest : StringSpec({
    "입력 받은 로또 라인의 수가 0이면 예외 처리한다." {
        val exception = shouldThrowExactly<IllegalArgumentException> { LottoLines(listOf()) }
        exception.message shouldBe "1개 이상의 로또 라인을 가지고 있어야 합니다."
    }
})
