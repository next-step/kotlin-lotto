package stringadder.domain

class Delimiters(vararg delimiter: String = emptyArray()) {
    val list: List<String> = listOf(",", ":", *delimiter)
}
