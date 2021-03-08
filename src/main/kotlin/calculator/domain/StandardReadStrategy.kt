package calculator.domain

import calculator.interfaces.StringReadStrategy

class StandardReadStrategy() : StringReadStrategy {
    override fun readString(string: String): List<String> {
        return string.split(",", ":")
    }
}
