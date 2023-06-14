package string

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class DefaultSeparatorStringSplitterTest : StringSpec({
    val sut = DefaultSeparatorStringSplitter()

    "컴마를 분할자로 가지면 숫자 토큰이 분할된 정수형 리스트를 반환한다" {
        sut.split("1,2,3") shouldBe listOf(1,2,3)
    }
})