package calculator.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class SeparatorsTest : BehaviorSpec() {
    private lateinit var separators: Separators

    init {
        given("기본 구분자만 있는 구분자 객체에") {
            separators = Separators()
            `when`("기본 구분자가") {
                val defaultSeparators = listOf(',', ':')
                then("모두 포함되어 있다.") {
                    separators.value.containsAll(defaultSeparators) shouldBe true
                }
            }

            `when`("커스텀 구분자가 포함되지 않은 문자열로 분리하면") {
                val input = "1,2:3,4"
                val tokens = separators.separate(input)
                then("기본 구분자로 잘 분리된다.") {
                    tokens.size shouldBe 4
                }
            }

            `when`("커스텀 구분자가 포함된 문자열로 분리하면") {
                val input = "//;\n1;2;3;4,5"
                val tokens = separators.separate(input)

                then("추가된 구분자로 잘 분리된다.") {
                    tokens.size shouldBe 5
                }
            }
        }
    }
}
