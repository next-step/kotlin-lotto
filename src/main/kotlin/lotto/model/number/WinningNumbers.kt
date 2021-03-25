package lotto.model.number

import java.util.TreeSet

data class WinningNumbers(private val winningNumbers: TreeSet<WinningNumber>) : Set<WinningNumber> by winningNumbers
