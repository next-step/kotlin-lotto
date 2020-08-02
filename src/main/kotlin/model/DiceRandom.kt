package model

interface DiceRandom {
    val diceList: List<Int>
    fun dice(): Int
    fun isContainList(value: Int): Boolean
}
