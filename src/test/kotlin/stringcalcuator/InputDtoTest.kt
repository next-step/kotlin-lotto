package stringcalcuator

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import stringcalculator.InputDto

class InputDtoTest : DescribeSpec({

    describe("커스텀 연산자, 숫자 집합을 나누어서 저장한다") {
        it("커스텀 구분자가 없는 경우 숫자 집합만을 저장한다") {
            // given
            val numbersString = "1,2,3,4"

            // when
            val inputDto = InputDto(numbersString)

            // then
            inputDto.numbersString shouldBe numbersString
        }

        it("커스텀 구분자가 있는 경우 커스텀 구분자, 숫자 집합을 저장한다") {
            // given
            val customSeparatorString = "//@\n"
            val numbersString = "1@2@3@4@5"
            val expression = customSeparatorString + numbersString

            // when
            val inputDto = InputDto(expression)

            // then
            inputDto.customSeparatorString shouldBe customSeparatorString
            inputDto.numbersString shouldBe numbersString
        }
    }

    describe("유효성 검사를 수행한다.") {
        it("커스텀 구분자 가 없고 경우 숫자, ',' ':' 를 제외한 문자 입력시 IllegalArgumentException 발생") {
            // given
            val exceptionString = "123a123a123b"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                InputDto(exceptionString)
            }.message shouldBe "연삭식에 숫자, 구분자를 제외한 문자가 들어가 있습니다."
        }

        it("커스텀 구분자 인 경우 `;n` 이후에 숫자, ',' ':', 커스텀 구분자를 제외한 문자 입력시 IllegalArgumentException 발생") {
            // given
            val customSeparator = "//$\n"
            val exceptionString = "123-1234+"

            // then
            shouldThrowExactly<IllegalArgumentException> {
                InputDto(customSeparator + exceptionString)
            }.message shouldBe "연삭식에 숫자, 구분자를 제외한 문자가 들어가 있습니다."
        }

        it("커스텀 구분자 인 경우 `;n` 이후에 숫자, ',' ':', 커스텀 구분자를 포함한 문자만 입력시 에러가 발생하지 않는다") {
            // given
            val customSeparator = "//$\n"
            val exceptionString = "1$2$3$5$6$"

            // then
            shouldNotThrow<Exception> {
                InputDto(customSeparator + exceptionString)
            }
        }
    }
})
