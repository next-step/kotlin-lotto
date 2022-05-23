package lotto

class Lotto(val generate: () -> Int) {
    val numbers: Set<Int>
        get() {
            val list = mutableListOf<Int>()
            do {
                addDistinctValue(list)
            } while (list.size < LOTTO_NUMBER_COUNT)
            return list.toSet()
        }

    private fun addDistinctValue(list: MutableList<Int>) {
        val number = generate()
        if (number !in list) list.add(number)
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_NUMBER_DIVIDE_TEXT = ","
    }
}

fun generate(): Int = (1..45).random()
