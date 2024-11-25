package calculator

class StringAddCalculator {

    fun add(text: String?): Int {

        if (text.isNullOrEmpty()) {
            return 0;
        }

        if (text.length == 1) {
            return text.toInt();
        }

        if (text.contains(",") || text.contains(":")) {

            val numbers = text.split(",|:".toRegex()).toTypedArray()
            return numbers.map { it.toInt() }.sum()

        }

        if (text.startsWith("//") && text.contains("\n")) {
            val customDelimiter = text.substring(2, 3)
            val numbers = text.substring(4).split(customDelimiter).toTypedArray()
            return numbers.map { it.toInt() }.sum()
        }

        if (text.contains("-")) {
            throw RuntimeException()
        }


        return 0
    }
}
