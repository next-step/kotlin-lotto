package calculator

class StringAddCalculator {

    fun add(text: String?): Int {

        if (text.isNullOrEmpty()) {
            return 0;
        }

        if (text.length == 1) {
            return text.toInt();
        }

        val numbers = NumberParser().parse(text)
        NumberValidator().validate(numbers)
        return numbers.sum()
    }

}
