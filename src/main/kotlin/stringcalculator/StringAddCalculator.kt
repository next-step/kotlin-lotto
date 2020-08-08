package stringcalculator

<<<<<<< HEAD
class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) checkInt(text)
        return if (regexSplit(text) == -1) {
            splitText(text)
        } else regexSplit(text)
    }

    private fun splitText(text: String): Int {

        val tokens = text.split(",", ":")
        tokens.forEach {
            negativeCheck(it)
            if (it.toInt().toString() != it) throw IllegalArgumentException("$it not allowed")
            return resultSum(tokens)
        }
        return -1
    }

    private fun negativeCheck(number: String) {
        if (number.toInt() < 0) throw RuntimeException("$number is negative")
    }

    private fun checkInt(text: String) {
        if (text.toInt().toString() != text) throw IllegalArgumentException("숫자만 입력이 가능합니다.")
        negativeCheck(text)
    }

    private fun resultSum(inputnumbers: List<String>): Int {
        inputnumbers.forEach { inputnumber -> if (inputnumber.toInt() < 0) throw RuntimeException("$inputnumber is negative") }
        return inputnumbers.map { it.toInt() }.sum()
    }

    private fun regexSplit(text: String): Int {

=======
import java.lang.IllegalArgumentException

class StringAddCalculator {

    fun add(text: String): Int {
        if (text.isBlank()) return 0
        if (text.isEmpty()) return 0
        if (text.length == 1) return text.toInt()
        val splittext = text.split(",", ":")
>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
        val result = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
<<<<<<< HEAD
            return resultSum(tokens)
        }
        return -1
    }
}
=======
            tokens.forEach{if (it.toInt() < 0) throw RuntimeException("$it is negative") }
            return tokens.map { it.toInt() }.sum()
        }
        splittext.forEach{if (it.toInt() < 0) throw RuntimeException("$it is negative") }
        return splittext.map { it.toInt() }.sum()
    }
    fun negativecheck(number: Int){
        if(number < 0) throw RuntimeException("$number is negative")
    }
}


>>>>>>> 4ac6c8dafa5439807629472fb598c89148432157
