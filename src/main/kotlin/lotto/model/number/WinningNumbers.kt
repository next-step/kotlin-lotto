package lotto.model.number

import java.util.TreeSet

data class WinningNumbers(private val winningNumbers: TreeSet<WinningNumber>) : Set<WinningNumber> by winningNumbers {
    constructor(winningNumbers: List<Int>) : this(TreeSet(winningNumbers.map { WinningNumber.get(it) }))
}
