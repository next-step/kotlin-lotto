package calculator

data class Numbers(val values: List<Number>) {
    fun sum(): Int = values.sumOf { it.toInt() }

    companion object {
        fun from(strings: List<String>): Numbers {
            return Numbers(strings.map { Number.from(it) })
        }
    }
}
