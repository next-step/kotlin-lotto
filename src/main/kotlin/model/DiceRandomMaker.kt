package model

import kotlin.random.Random

class DiceRandomMaker() : DiceRandom {
    private val diceListMutable = mutableListOf<Int>()
    override val diceList: List<Int>
        get() = diceListMutable.toList()

    override fun dice(): Int {
        var number: Int
        do {
            number = Random.nextInt(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER)
        } while (isContainList(number))

        diceListMutable.add(number)
        return number
    }

    override fun isContainList(value: Int) = diceList.contains(value)

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 50
    }
}
