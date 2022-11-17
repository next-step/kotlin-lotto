package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith

class SeparatorsTest : BehaviorSpec({
    given("구분자 일급 컬렉션에") {
        val separators = Separators()
        `when`("지정한 기본인자가") {
            val defaultSeparators = listOf(',', ':')
            then("모두 포함되어 있다.") {
                separators.get().containsAll(defaultSeparators) shouldBe true
            }
        }

        `when`("새로 구분자를 추가했을 때") {
            and("문자라면") {
                val characterSeparator = '&'
                separators.add(characterSeparator)
                then("잘 추가된다.") {
                    separators.get().contains(characterSeparator) shouldBe true
                }
            }

            and("숫자라면") {
                val numberSeparator = '3'
                then("IllegalArgumentException 를 반환한다.") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        separators.add(numberSeparator)
                    }
                    exception.message should startWith("숫자는 구분자가 될 수 없습니다.")
                }
            }
        }
    }
})
