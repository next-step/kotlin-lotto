package lotto

class Numbers(private val _list: List<Int> = listOf()) {
    val list
        get() = _list

    val size = _list.size
}
