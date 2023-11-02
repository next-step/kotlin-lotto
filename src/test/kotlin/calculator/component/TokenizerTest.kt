package calculator.component

import calculator.fixture.TokenFixture
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class TokenizerTest : StringSpec({
    "콜론(:)은 구분자로 동작 해야 한다" {
        val actual = Tokenizer.tokenize("1:2:3")
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "쉼표(,)는 구분자로 동작 해야 한다" {
        val actual = Tokenizer.tokenize("1,2,3")
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "구분자를 컴마(,) 이외에 콜론(:)을 동시에 사용할 수 있다" {
        val actual = Tokenizer.tokenize("1,2:3")
        actual shouldHaveSize 3
        actual shouldContain TokenFixture.TOKEN[1]
        actual shouldContain TokenFixture.TOKEN[2]
        actual shouldContain TokenFixture.TOKEN[3]
    }

    "커스텀 구분자는 문자열 앞 부분의 “//”와 “\\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다." {
        // “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다
    }

    "\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        val actual = Tokenizer.tokenize("//;\\n1;2;3")
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
