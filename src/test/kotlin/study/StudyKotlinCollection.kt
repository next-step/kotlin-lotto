package study

import io.kotest.core.spec.style.StringSpec

class StudyKotlinCollection : StringSpec({

    "참고한사이트" {
        println("https://kotlinlang.org/docs/collections-overview.htm")
        println("https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/")
    }

    "Set 자료구조" {
        val numbers = setOf(1, 2, 3, 4)
        println("Number of elements: ${numbers.size}")
        if (numbers.contains(1)) println("1 is in the set")

        val numbersBackwards = setOf(4, 3, 2, 1)
        println("The sets are equal: ${numbers == numbersBackwards}")
    }
})
