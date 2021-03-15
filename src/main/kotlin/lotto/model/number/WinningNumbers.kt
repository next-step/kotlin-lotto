package lotto.model.number

import java.util.TreeSet

class WinningNumbers(winningNumbers: TreeSet<WinningNumber>) : LottoNumbers(winningNumbers) {
    constructor(winningNumbers: List<Int>) : this(TreeSet(winningNumbers.map { WinningNumber.get(it) }))
}
