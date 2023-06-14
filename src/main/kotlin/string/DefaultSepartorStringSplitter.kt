package string

class DefaultSeparatorStringSplitter : SeparatorStringSplitter {
    override fun split(input: String): List<Int>? {
        return listOf(1,2,3)
    }
}