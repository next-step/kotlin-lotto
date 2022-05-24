package lotto

class Lotto(generateLists: (Int) -> List<Int>) {
    var numbers: List<Int> = listOf()

    init {
        numbers = generateLists(LOTTO_NUMBER_COUNT)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_DIVIDE_TEXT = ","
    }
}

fun generateNumbers(count: Int): List<Int> {
    val list = mutableListOf<Int>()
    do {
        addDistinctValue(list)
    } while (list.size < count)
    return list
}

fun addDistinctValue(list: MutableList<Int>) {
    val number = (1..45).random()
    if (number !in list) list.add(number)
}
