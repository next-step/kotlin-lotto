package lotto.domain

import lotto.constants.Sort

interface ShuffleNumber {

    fun shuffleNumber(): List<Int>
    fun takeShuffleNumber(takeCount: Int, sort: Sort = Sort.ASC): List<Int> {
        return shuffleNumber().take(takeCount).numberSort(sort)
    }

    private fun List<Int>.numberSort(sort: Sort): List<Int> {
        if (sort == Sort.DESC) {
            return this.sortedDescending()
        }
        return this.sorted()
    }
}
