package lotto

import org.junit.jupiter.api.Test
import java.util.TreeSet

class LottoTest {

    @Test
    fun treeSetTest() {
        val numberList = listOf(3, 5, 7, 4, 2, 4, 6, 4, 3,)
        val treeSet = TreeSet(numberList)
        println(treeSet)
    }
}
