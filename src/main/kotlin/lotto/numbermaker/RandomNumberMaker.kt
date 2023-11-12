package lotto.numbermaker

class RandomNumberMaker(private val size: Int = 6) {
    private val numberList: MutableList<Int> = mutableListOf<Int>()
    init {
        for (i in 1..45) {
            numberList.add(i)
        }
    }
    fun generate(): List<Int> {
        return numberList.shuffled().subList(0, 6)
    }
}
