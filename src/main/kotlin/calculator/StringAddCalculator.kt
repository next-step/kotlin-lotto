package calculator

class StringAddCalculator {

    fun add(input: String?): Int {

        if (input.isNullOrEmpty()) {
            return 0;
        }

        if (input.length == 1) {
            return input.toInt();
        }

        return NumberParser(
            listOf(
                CustomDelimiterStrategy(),
                DefaultDelimiterStrategy()
            )
        ).parseNumbers(input).sum()
    }
}
