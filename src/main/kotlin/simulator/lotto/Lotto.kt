package simulator.lotto

class Lotto(val number: Number) {
    override fun toString(): String {
        return number.values.joinToString(",")
    }

    fun rank(winningNumber: Lotto, bonusNumber: Int): Rank {
        return Rank.valueOf(match(winningNumber), number.values.contains(bonusNumber))
    }

    private fun match(lotto: Lotto): Int {
        var matches = 0
        lotto.number.values.forEach {
            if (number.values.contains(it)) matches++
        }
        return matches
    }

    companion object {
        const val PRICE = 1000
    }
}
