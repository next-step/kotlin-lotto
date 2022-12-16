package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly

class SortedTest : FunSpec({
    test("sorted 오름차순") {
        val numbers = listOf(32, 10, 26, 12, 5)
        val sortedNumbers = numbers.sorted()
        sortedNumbers shouldContainExactly listOf(5, 10, 12, 26, 32)
    }
})
