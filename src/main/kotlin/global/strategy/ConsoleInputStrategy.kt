package global.strategy

object ConsoleInputStrategy : InputStrategy {
    override fun input(): String? = readLine()
}
