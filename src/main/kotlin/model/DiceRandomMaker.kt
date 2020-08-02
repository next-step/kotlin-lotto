package model

class DiceRandomMaker() : DiceRandom {
    private val diceListMutable = IntRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).shuffled().take(LOTTO_SIZE)
    override val diceList: List<Int>
        get() = diceListMutable.toList()

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 50
        const val LOTTO_SIZE = 6
    }
}
