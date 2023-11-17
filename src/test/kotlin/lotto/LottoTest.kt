package lotto

import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun treeSetTest() {
        val numberList = listOf(3, 5, 7, 4, 2, 4, 6, 4, 3,)
        val linkedHashSet = LinkedHashSet(numberList)
        println(linkedHashSet)
    }
}
