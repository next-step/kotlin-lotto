package specific.lotto.domain

import hasDuplicate
import isSortedAsc


data class NumberCombination(val numbers: List<Int>) {
    init {
        require(numbers.all { it in 1..45 }) { "'numbers' must be from 1 to 45" }
        require(!numbers.hasDuplicate()) { "'numbers' must not contain duplicate numbers" }
        require(numbers.isSortedAsc()) { "'numbers' must be an ascending ordered number" }
        require(numbers.size == 6) { "'numbers' must be 6 numbers" }
    }
}
