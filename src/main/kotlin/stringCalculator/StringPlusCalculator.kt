package stringCalculator

object StringPlusCalculator {

    const val DEFAULT_SEPERATOR_1 = ":"
    const val DEFAULT_SEPERATOR_2 = ","
    const val CUSTOM_SEPERATOR_PREFIX = "//"
    const val CUSTOM_SEPERATOR_POSTFIX = "\n"
    const val CUSTOM_SEPERATOR_POSITION = 0
    const val VALUE_POSITION = 1

    private var customSeperators = mutableListOf(DEFAULT_SEPERATOR_1, DEFAULT_SEPERATOR_2)
    fun seperate(string: String): List<Int> {
        if(string.isEmpty()) {
            return listOf(0)
        }
        var convertedString = string
        if(CUSTOM_SEPERATOR_PREFIX in string && CUSTOM_SEPERATOR_POSTFIX in string) {
            val splitStrings = string.split(CUSTOM_SEPERATOR_POSTFIX)
            convertedString = splitStrings[VALUE_POSITION]
            customSeperators.add(splitStrings[CUSTOM_SEPERATOR_POSITION].split(CUSTOM_SEPERATOR_PREFIX)[VALUE_POSITION])

//            val customSeperator = [0].split(CUSTOM_SEPERATOR_PREFIX)[0]
//            println(customSeperator)

        }
        return convertedString.split(*customSeperators.toTypedArray()).map {
            it.toInt()
        }
    }
}
