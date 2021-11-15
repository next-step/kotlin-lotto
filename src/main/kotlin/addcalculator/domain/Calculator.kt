package addcalculator.domain

object Calculator {

    fun sum(stringValues: List<StringValue>): Int {
        return stringValues.map { it.number }
            .reduce { total, number -> total + number }
    }
}
