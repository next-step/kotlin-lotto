package domain

import java.util.*

class MockNumbers(private val numbers: LinkedList<Int>) : Numbers {
    override fun makeNumber(min: Int, max: Int): Int {
        return numbers.pop()
    }

    fun retrieveNumber(): Int {
        return numbers.pop()
    }
}
