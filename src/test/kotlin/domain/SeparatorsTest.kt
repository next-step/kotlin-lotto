package domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class SeparatorsTest : BehaviorSpec({
    given("구분자 일급 컬렉션에") {
        val separators = Separators()
        `when`("지정한 기본인자가") {
            val defaultSeparators = listOf(',', ':')
            then("모두 포함되어 있다.") {
                separators.get().containsAll(defaultSeparators) shouldBe true
            }
        }

        `when` ("새로 구분자를 추가했을 때") {
            val newSeparator = '&'
            separators.add(newSeparator)
            then("잘 추가된다.") {
                separators.get().contains(newSeparator) shouldBe true
            }
        }
    }
})
