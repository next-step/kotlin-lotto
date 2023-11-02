package calculator.component

import calculator.fixture.TokenFixture
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class TokenizerTest : StringSpec({
    "콜론(:)은 구분자로 동작 해야 한다" {
        val actual = Tokenizer.tokenize("1:2:3").tokens
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "쉼표(,)는 구분자로 동작 해야 한다" {
        val actual = Tokenizer.tokenize("1,2,3").tokens
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "구분자를 컴마(,) 이외에 콜론(:)을 동시에 사용할 수 있다" {
        val actual = Tokenizer.tokenize("1,2:3").tokens
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "빈 문자열 을 입력하는 경우 비어있는 컬렉션을 반환해야한다" {
        val actual = Tokenizer.tokenize("").tokens
        actual shouldHaveSize 0
    }

    "'0' 문자열 을 입력하는 경우 '0' 원소를 반환해야한다" {
        val actual = Tokenizer.tokenize("0").tokens
        actual shouldHaveSize 1
        actual shouldContain TokenFixture.TOKEN[0]
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다" {
        val actual = Tokenizer.tokenize("55").tokens
        actual shouldHaveSize 1
        actual shouldContain TokenFixture.TOKEN[55]
    }

    "\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        val actual = Tokenizer.tokenize("//;\n1;2;3").tokens
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "숫자 이외의 값을 전달하는 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Tokenizer.tokenize("1L,2:3")
        }
    }

    "음수를 전달하는 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Tokenizer.tokenize("1,-2:3")
        }
    }
})
