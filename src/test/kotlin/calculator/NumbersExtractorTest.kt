package calculator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class NumbersExtractorTest : BehaviorSpec({

    Given("빈 문자열 또는 null을 입력할 경우") {
        val texts = listOf(null, "", " ")
        When("피연산자를 추출하면") {
            texts.forAll {
                val result = NumbersExtractor.run(it)
                Then("숫자 0이 담긴 리스트가 반환된다.") {
                    val expected = listOf(0)
                    result.map { number ->
                        number.value
                    } shouldBe expected
                }
            }
        }
    }

    Given("숫자 하나를 문자열로 입력할 경우") {
        val text = "1"
        When("피연산자를 추출하면") {
            val result = NumbersExtractor.run(text)
            Then("해당 숫자가 담긴 리스트가 반환한다.") {
                val expected = listOf(1)
                result.map { number ->
                    number.value
                } shouldBe expected
            }
        }
    }

    Given("여러 숫자를 쉼표(,) 구분자로 입력할 경우") {
        val text = "1,2"
        When("피연산자를 추출하면") {
            val result = NumbersExtractor.run(text)
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                val expected = listOf(1, 2)
                result.map {
                    it.value
                } shouldBe expected
            }
        }
    }

    Given("여러 숫자를 쉼표(,) 이외에 콜론(:)도 구분자로 입력할 경우") {
        val text = "1,2:3"
        When("피연산자를 추출하면") {
            val result = NumbersExtractor.run(text)
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                val expected = listOf(1, 2, 3)
                result.map {
                    it.value
                } shouldBe expected
            }
        }
    }

    Given("여러 숫자를 커스텀 구분자로 입력할 경우") {
        val text = "//;\n1;2;3"
        When("피연산자를 추출하면") {
            val result = NumbersExtractor.run(text)
            Then("해당 숫자들이 담긴 리스트가 반환된다.") {
                val expected = listOf(1, 2, 3)
                result.map {
                    it.value
                } shouldBe expected
            }
        }
    }
})
