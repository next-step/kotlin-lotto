package lotto.domain

class Statistics {

    private val value: Map<Int, MutableList<Lotto>> = mutableMapOf(
        3 to mutableListOf(),
        4 to mutableListOf(),
        5 to mutableListOf(),
        6 to mutableListOf(),
    )

    fun add(count: Int, lotto: Lotto) {
        value[count]?.add(lotto) ?: mutableListOf(lotto)
    }

    fun from(count: Int): List<Lotto> {
        if(count <= 2) {
            return emptyList()
        }

        return value[count]?.toList() ?: throw IllegalStateException()
    }

    fun keys(): List<Int> = listOf(3, 4, 5, 6)
}