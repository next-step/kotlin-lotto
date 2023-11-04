package lotto_auto.ui

object OutputView {
    fun print(list: List<List<Int>>) {
        list.forEach {
            println(it)
        }
    }
}
