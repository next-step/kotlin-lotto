package stringcalculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class DelimitersTest : StringSpec({
    "기본 구분자는 , 와 : 이다." {
        val delimiters = Delimiters()
        delimiters.delimiters shouldContainAll listOf(",", ":")
    }
    "구분자들을 통해 정규식을 만들어준다." {
        val delimiters = Delimiters()
        delimiters.getDelimitersRegex() shouldBe "[,:]".toRegex()
    }
})
