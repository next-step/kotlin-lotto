package lotto

class Lotto(val generateLists: (Int) -> Set<Int>) {
    val numbers: Set<Int>
        get() = generateLists(LOTTO_NUMBER_COUNT)

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_DIVIDE_TEXT = ","
    }
}

fun generateNumbers(count: Int): Set<Int> {
    val list = mutableListOf<Int>()
    do {
        addDistinctValue(list)
    } while (list.size < count)
    return list.toSet()
}

fun addDistinctValue(list: MutableList<Int>) {
    val number = (1..45).random()
    if (number !in list) list.add(number)
}
