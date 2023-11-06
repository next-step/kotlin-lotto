package lotto.numbermaker

class RandomNumberMaker(private val size: Int = 6) {
    fun getNumber(): List<Int> {
        val numberList = mutableListOf<Int>()
        for (i in 1..45) {
            numberList.add(i)
        }
        return numberList.shuffled().subList(0, 6)
    }
}
