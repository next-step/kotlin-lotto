package lotto.domain

class ManualLotto {
    private val numbersList = mutableListOf<List<Int>>()

    fun add(list: List<Int>) {
        numbersList.add(list)
    }

    fun getAll(): List<List<Int>> {
        return numbersList
    }
}
