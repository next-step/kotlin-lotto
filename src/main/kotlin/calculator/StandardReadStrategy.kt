package calculator

class StandardReadStrategy() : StringReadStrategy {
    override fun readString(string: String): List<String> {
        return string.split(",", ":")
    }
}
