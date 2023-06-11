object StringAddCalculator {
    fun add(command: String?): Int {
        if (command.isNullOrEmpty() || command.isBlank()) {
            return 0
        }
        return command.split(",").sumOf { it.toInt() }
    }
}