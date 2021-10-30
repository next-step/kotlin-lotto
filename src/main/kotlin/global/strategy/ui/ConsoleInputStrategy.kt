package global.strategy.ui

object ConsoleInputStrategy : InputStrategy {
    private const val LITERAL_NEW_LINE = """\n"""
    private const val ACTIVE_NEW_LINE = "\n"

    override fun input(): String? {
        return readLine()?.let { it.replace(LITERAL_NEW_LINE, ACTIVE_NEW_LINE) }
    }
}
