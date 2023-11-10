package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class 숫자_목록_추가_테스트 : StringSpec({

    "숫자 목록에 음수를 추가하면, 예외가 발생한다." {
        listOf(-1, -5, -2, -7, -122, -254).forEach {
            val 양수_숫자_목록 = PositiveNumbers()

            shouldThrow<RuntimeException> {
                양수_숫자_목록.add(it)
            }.message shouldBe "숫자는 0 이상의 양수를 입력해주세요."
        }
    }
})
