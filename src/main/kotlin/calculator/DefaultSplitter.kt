package calculator

class DefaultSplitter : Splitter {

    override fun split(text: String): List<String> = text.split("[$DELIMITER]".toRegex())

    companion object {
        private const val DELIMITER = ",:"
    }
}
