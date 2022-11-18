package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class CollectionTest : StringSpec() {
    init {
        "shuffled()" {
            val list: List<Int> = (1..45).map { it }
            val subList = list.shuffled().subList(0, 6)

            subList shouldHaveSize 6
        }

        "distinct()" {
            val list: List<Int> = (1..45).map { it }

            list.subList(0, 6) shouldBe list.subList(0, 6)
        }
    }
}
