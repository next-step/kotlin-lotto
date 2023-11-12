data class Lotto(
    val numbers: List<Int>,
) {
    var matchCount: Int = 0
        private set

    fun match(count: Int) {
        matchCount = count
    }
}
