package calculator.domain

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) {
            return 0
        }

        val regex = Separator.toRegexWith("|")
        val addNumbers = AddNumbers.of(text.split(regex = regex))
        return addNumbers.addAll().value
    }
}
