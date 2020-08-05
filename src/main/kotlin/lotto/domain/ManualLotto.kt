package lotto.domain

class ManualLotto {
    private val numbersList = mutableListOf<List<Int>>()

    fun add(list: List<Int>) {
        numbersList.add(list)
    }

    fun addAll(list: List<List<Int>>) {
        numbersList.addAll(list)
    }

    fun getAll(): List<List<Int>> {
        return numbersList
    }
}
