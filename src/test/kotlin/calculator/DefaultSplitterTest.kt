package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class DefaultSplitterTest : FunSpec({
    context("문자열 분리") {
        context("문자열을 전달하면") {
            test("콤마(,) 를 기준으로 문자열을 분리할 수 있다.") {
                // given
                val expression = Expression.from("1,2,3")
                val sut = DefaultSplitter()
                // when
                val actual = sut.split(expression)
                // then
                actual shouldContainExactly listOf("1", "2", "3")
            }

            test("콜론(:) 을 기준으로 문자열을 분리할 수 있다.") {
                // given
                val expression = Expression.from("2:3:4")
                val sut = DefaultSplitter()
                // when
                val actual = sut.split(expression)
                // then
                actual shouldContainExactly listOf("2", "3", "4")
            }

            test("콤마(,) 또는 콜론(:) 을 기준으로 문자열을 분리할 수 있다.") {
                // given
                val expression = Expression.from("3,4:5")
                val sut = DefaultSplitter()
                // when
                val actual = sut.split(expression)
                // then
                actual shouldContainExactly listOf("3", "4", "5")
            }
        }
    }
})
