package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class DelimitersTest : StringSpec({
    "기본 구분자는 , 와 : 이다." {
        val delimiters = Delimiters()
        delimiters.delimiters shouldContainAll listOf(",", ":")
    }
    "새로운 커스텀한 구분자를 추가할 수 있다." {
        val delimiters = Delimiters()
        delimiters.addDelimiter("&&")
        delimiters.delimiters shouldContain "&&"
    }
    "구분자들을 통해 정규식을 만들어준다." {
        val delimiters = Delimiters()
        delimiters.getDelimitersRegex() shouldBe "[,:]".toRegex()
    }
    "커스텀한 구분자를 추가할 경우 정규식에 포함된다." {
        listOf("#", "?", "^^").forAll {
            val delimiters = Delimiters()
            delimiters.addDelimiter(it)
            delimiters.getDelimitersRegex() shouldBe "[,:$it]".toRegex()
        }
    }
})
