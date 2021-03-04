package calculator

data class Sum(private val intList: List<Int>) {
    fun toInt() = intList.sum()
}
