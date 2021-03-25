package lotto.model.number

import java.util.TreeSet

object WinningNumbersFactory {
    fun create(winningNumbers: TreeSet<WinningNumber>): WinningNumbers {
        return WinningNumbers(TreeSet(winningNumbers))
    }

    fun create(winningNumbers: List<Int>): WinningNumbers {
        return WinningNumbers(TreeSet(winningNumbers.map { WinningNumber.get(it) }))
    }
}
