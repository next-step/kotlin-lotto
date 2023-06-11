object StringAddCalculator {
    fun add(command: String?): Int {
        if (command.isNullOrEmpty()) {
            return 0
        }
        return command.toInt()
    }
}