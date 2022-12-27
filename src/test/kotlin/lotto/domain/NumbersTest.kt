package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class NumbersTest: StringSpec({

    "정의 된 숫자만큼 생성 되는지 확인"{
        Numbers().size() shouldBe 6
    }

    "중복 제거한 사이즈 확인"{
        Numbers(issueNumbers = listOf(1,1,1,1)).duplicateSize() shouldBe 1
    }

    "매칭 되는 숫자 개수 확인"{
        Numbers(issueNumbers = listOf(1,2,3,4,5,6)).getMatchingNumbers(Numbers(listOf(1,2,3,4,5,6))) shouldBe 6
    }
})
