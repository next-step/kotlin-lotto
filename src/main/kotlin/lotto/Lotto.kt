package lotto

class Lotto {
    val lotto = getRandomNumbers()

    private fun getRandomNumbers(): List<Int> {
        return (1..45).map { it }.shuffled().subList(0, 6).sorted()
    }

    override fun toString(): String {
        return "$lotto"
    }
}
