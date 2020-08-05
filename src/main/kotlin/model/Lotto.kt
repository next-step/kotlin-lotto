package model

class Lotto(diceRandom: DiceRandom) {
    val lottoNumber = diceRandom.diceList.sorted()

    fun matchCount(prize: List<Int>): Int {
        return lottoNumber.count { prize.contains(it) }
    }

    companion object {
        const val MAKE_NUMBER_COUNT = 6
    }
}
