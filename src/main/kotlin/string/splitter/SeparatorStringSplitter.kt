package string.splitter

/**
 * [input] 이 커스텀 구분자를 사용하는 식이면 `true` 를 반환하고
 * 커스텀 구분자를 사용하지 않는 식이면 `false` 를 반환한다
 */
fun interface SeparatorStringSplitter {
    fun split(input: String): List<Int>?
}
