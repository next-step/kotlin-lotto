class StringAddition(private val exp: String) {
    fun execute(): Int {
        return exp
            .takeIf { it.isNotEmpty() }
            ?.split(Regex("(,|:)"))
            ?.map { it.toInt() }
            ?.fold(0) { total: Int, num: Int -> total + num }
            ?: 0
    }
}
