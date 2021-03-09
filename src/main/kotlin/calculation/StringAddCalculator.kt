package calculation

import java.lang.RuntimeException

class StringAddCalculator {

    fun add(inputData: String?): Int {
        val resultValue: Int = if (inputData.isNullOrBlank()) 0 else addCalculation(inputData)
        if (resultValue < 0) { throw RuntimeException() }
        return resultValue
    }

    private fun addCalculation(inputData: String): Int {
        return addCalculationByRegex(inputData) ?: addDefaultCalculation(inputData)
    }

    private fun addDefaultCalculation(inputData: String): Int {
        return inputData.split(",", ":").map { it.toInt() }.sum()
    }

    private fun addCalculationByRegex(inputData: String): Int? {
        val result = Regex("//(.)\n(.*)").find(inputData)
        val customDelimiter = result?.groupValues?.get(1)
        if (customDelimiter != null) {
            val valueList = result.groupValues[2].split(customDelimiter)
            return valueList.map { it.toInt() }.sum()
        }
        return null
    }
}
